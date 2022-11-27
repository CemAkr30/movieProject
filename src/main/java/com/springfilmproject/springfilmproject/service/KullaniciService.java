package com.springfilmproject.springfilmproject.service;

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

    public List<Kullanici> getAllKullanici(){
        return kullaniciRepository.findAll();
    }

    public Kullanici getKullanici( Long kullaniciId ){
        return kullaniciRepository.findById(kullaniciId).orElse(null);
    }

    @Query("SELECT u FROM Kullanici u WHERE u.kullaniciAdi = ?1 and u.sifre = ?2")
    public List<Kullanici> getLogin( String kullaniciAdi, String sifre ){
      return kullaniciRepository.findAll();
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
