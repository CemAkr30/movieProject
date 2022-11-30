package com.springfilmproject.springfilmproject.Kullanici;

import com.springfilmproject.springfilmproject.model.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KullaniciRepository extends JpaRepository<Kullanici,Long> {
    Long countByKullaniciAdiAndSifre(String kullaniciAdi, String sifre);
}
