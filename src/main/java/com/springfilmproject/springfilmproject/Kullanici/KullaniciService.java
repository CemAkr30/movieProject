package com.springfilmproject.springfilmproject.Kullanici;

import com.springfilmproject.springfilmproject.defaults.Defaults;
import com.springfilmproject.springfilmproject.converters.CinsiyetConverter;
import com.springfilmproject.springfilmproject.enums.Cinsiyet;
import com.springfilmproject.springfilmproject.exception.CoreMessageException;
import com.springfilmproject.springfilmproject.model.Kullanici;
import com.springfilmproject.springfilmproject.validation.Validation;
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
        return Validation.checkNumber(kullaniciRepository.countByKullaniciAdiAndSifre(kullaniciAuthDto.getKullaniciAdi(), kullaniciAuthDto.getSifre())
        ) ? Defaults.JSON_TRUE : Defaults.JSON_FALSE;
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
        Cinsiyet cinsiyet = null;
        if(kullaniciDto!=null){
            cinsiyet = cinsiyetConverter.convertToEntityAttribute(kullaniciDto.getCinsiyet());
              if( kullaniciDto.getKullaniciAdi()==null || kullaniciDto.getSifre()==null && kullaniciDto.getEmail()==null
                      || kullaniciDto.getCinsiyet()==null
             || "".equals(kullaniciDto.getEmail()) || "".equals(kullaniciDto.getSifre())
                      || "".equals(kullaniciDto.getKullaniciAdi()) || "".equals(kullaniciDto.getCinsiyet()) ){
                   throw new CoreMessageException("Alanlar boş olamaz!!!");
               }

                kullanici.setKullaniciAdi(kullaniciDto.getKullaniciAdi());
                kullanici.setSifre(kullaniciDto.getSifre());
                kullanici.setEmail(kullaniciDto.getEmail());
                kullanici.setCinsiyet(cinsiyet);

             kullaniciRepository.save(kullanici);
        }
        return kullanici;
    }

}
