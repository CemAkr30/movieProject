package com.springfilmproject.springfilmproject.Kullanici;

import com.springfilmproject.springfilmproject.enums.Cinsiyet;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KullaniciDto {
    private String kullaniciAdi;
    private String sifre;
    private String email;
    private Long cinsiyet;

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Long cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
}
