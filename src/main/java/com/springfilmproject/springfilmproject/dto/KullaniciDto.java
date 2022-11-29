package com.springfilmproject.springfilmproject.dto;

import com.springfilmproject.springfilmproject.enums.Cinsiyet;

import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@NoArgsConstructor
public class KullaniciDto {
    private String kullaniciAdi;
    private String sifre;
    private String email;
    private String cinsiyet;

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

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
}
