package com.springfilmproject.springfilmproject.Kullanici;

import com.springfilmproject.springfilmproject.defaults.Defaults;
import com.springfilmproject.springfilmproject.converters.CinsiyetConverter;
import com.springfilmproject.springfilmproject.enums.Cinsiyet;
import com.springfilmproject.springfilmproject.exception.CoreMessageException;
import com.springfilmproject.springfilmproject.model.Kullanici;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KullaniciService {

    private final KullaniciRepository kullaniciRepository;

    public KullaniciService(KullaniciRepository kullaniciRepository){
        this.kullaniciRepository = kullaniciRepository;
    }


    public List<Kullanici> getButunKullanici() {
        return kullaniciRepository.findAll();
    }

    public Kullanici getKullanici(Long kullaniciId) {
        return kullaniciRepository.findById(kullaniciId).orElse(null);
    }

    public String kullaniciVarMi(KullaniciAuthDto kullaniciAuthDto) {
        return  kullaniciRepository.countByKullaniciAdiAndSifre(kullaniciAuthDto.getKullaniciAdi(), kullaniciAuthDto.getSifre())
                ==1 ? Defaults.JSON_TRUE : Defaults.JSON_FALSE;
    }

    public boolean kullaniciSil(Long kullaniciId) {
        if (kullaniciRepository.findById(kullaniciId).isPresent()) {
            kullaniciRepository.deleteById(kullaniciId);
            return true;
        }
        return false;
    }

    public Kullanici createKullanici(KullaniciDto kullaniciDto) throws CoreMessageException {
        Kullanici kullanici = new Kullanici();
        CinsiyetConverter cinsiyetConverter = new CinsiyetConverter();

        if(kullaniciDto!=null){
                kullanici.setKullaniciAdi(kullaniciDto.getKullaniciAdi());
                kullanici.setSifre(kullaniciDto.getSifre());
                kullanici.setEmail(kullaniciDto.getEmail());
            Cinsiyet cinsiyet
            = cinsiyetConverter.convertToEntityAttribute(kullaniciDto.getCinsiyet());
            if(cinsiyet!=null){
                kullanici.setCinsiyet(cinsiyet);
            }else{
                throw new CoreMessageException("Cinsiyet alanı boş olamaz!!!");
            }
             kullaniciRepository.save(kullanici);
        }
        return kullanici;
    }

}
