package com.springfilmproject.springfilmproject.model;

import com.springfilmproject.springfilmproject.enums.Cinsiyet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "KULLANICI")
@NoArgsConstructor
public class Kullanici {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KULLANICI_ADI")
    private String kullaniciAdi;

    @Column(name = "SIFRE")
    private String sifre;

    @Column(name = "EMAIL")
    private String email;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "CINSIYET")
    private Cinsiyet cinsiyet;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    public Cinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Cinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kullanici kullanici = (Kullanici) o;
        return Objects.equals(id, kullanici.id) &&
                Objects.equals(kullaniciAdi, kullanici.kullaniciAdi) &&
                Objects.equals(sifre, kullanici.sifre) &&
                Objects.equals(email, kullanici.email) &&
                Objects.equals(cinsiyet, kullanici.cinsiyet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kullaniciAdi, sifre, email, cinsiyet);
    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "id=" + id +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                ", sifre='" + sifre + '\'' +
                ", email='" + email + '\'' +
                ", cinsiyet=" + cinsiyet +
                '}';
    }
}
