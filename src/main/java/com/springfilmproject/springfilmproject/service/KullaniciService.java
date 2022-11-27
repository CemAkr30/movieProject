package com.springfilmproject.springfilmproject.service;

import com.springfilmproject.springfilmproject.dto.KullaniciDto;
import com.springfilmproject.springfilmproject.enums.Cinsiyet;
import com.springfilmproject.springfilmproject.model.Kullanici;
import com.springfilmproject.springfilmproject.repository.KullaniciRepository;
import org.springframework.stereotype.Service;

@Service
public class KullaniciService {

    private final KullaniciRepository kullaniciRepository;

    public KullaniciService(KullaniciRepository kullaniciRepository){
        this.kullaniciRepository = kullaniciRepository;
    }


    public boolean createKullanici(KullaniciDto kullaniciDto){
        Kullanici kullanici
                 = new Kullanici();
            if(kullaniciDto!=null) {
                kullanici.setKullaniciAdi(kullaniciDto.getKullaniciAdi());
                kullanici.setSifre(kullaniciDto.getSifre());
                kullanici.setEmail(kullaniciDto.getEmail());

                if(kullaniciDto.getCinsiyet().equals(Cinsiyet.ERKEK)){
                    kullanici.setCinsiyet(Long.valueOf(1));
                }else{
                    kullanici.setCinsiyet(Long.valueOf(2));
                }
                kullaniciRepository.save(kullanici);
            }
        return true;
    }

}
