package com.springfilmproject.springfilmproject.service;

import com.springfilmproject.springfilmproject.dto.KullaniciAuthDto;
import com.springfilmproject.springfilmproject.dto.KullaniciDto;
import com.springfilmproject.springfilmproject.enums.Cinsiyet;
import com.springfilmproject.springfilmproject.model.Kullanici;
import com.springfilmproject.springfilmproject.repository.KullaniciRepository;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    public long kullaniciVarMi(KullaniciAuthDto kullaniciAuthDto) {
        return kullaniciRepository.countByKullaniciAdiAndSifre(kullaniciAuthDto.getKullaniciAdi(), kullaniciAuthDto.getSifre());
    }

    public boolean kullaniciSil(Long kullaniciId) {
        if (kullaniciRepository.findById(kullaniciId).isPresent()) {
            kullaniciRepository.deleteById(kullaniciId);
            return true;
        }
        return false;
    }

    public Kullanici createKullanici(KullaniciDto kullaniciDto) {
        Kullanici kullanici
                 = new Kullanici();
        if(kullaniciDto!=null){
                kullanici.setKullaniciAdi(kullaniciDto.getKullaniciAdi());
                kullanici.setSifre(kullaniciDto.getSifre());
                kullanici.setEmail(kullaniciDto.getEmail());
            if(Cinsiyet.ERKEK.toString().toUpperCase().equals(kullaniciDto.getCinsiyet().toString().toUpperCase())){
                kullanici.setCinsiyet(Cinsiyet.ERKEK);
            }else{
                kullanici.setCinsiyet(Cinsiyet.KADIN);
            }
                kullaniciRepository.save(kullanici);
        }
        return kullanici;
    }

}
