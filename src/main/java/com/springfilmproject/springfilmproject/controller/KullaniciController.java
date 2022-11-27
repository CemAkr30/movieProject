package com.springfilmproject.springfilmproject.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springfilmproject.springfilmproject.dto.KullaniciDto;
import com.springfilmproject.springfilmproject.enums.Cinsiyet;
import com.springfilmproject.springfilmproject.model.Kullanici;
import com.springfilmproject.springfilmproject.service.KullaniciService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/kullaniciLogin")
public class KullaniciController {

    private final KullaniciService kullaniciService;

    public KullaniciController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    @GetMapping
    public List<Kullanici> getAllKullanici(){
        return kullaniciService.getAllKullanici();
    }

    @GetMapping
    public Kullanici getKullanici(@PathVariable Long kullaniciId){
        return kullaniciService.getKullanici(kullaniciId);
    }

    @PostMapping
    public String createKullanici(String json){
        JSONObject obj = null;
        KullaniciDto kullaniciDto = new KullaniciDto();
        try {
            obj = new JSONObject(json);
        String kullaniciAdi = obj.getJSONObject("kullaniciAdi").toString();
        String sifre = obj.getJSONObject("sifre").toString();
        String email = obj.getJSONObject("email").toString();
        String cinsiyet = obj.getJSONObject("cinsiyet").toString();
        kullaniciDto.setKullaniciAdi(kullaniciAdi);
        kullaniciDto.setSifre(sifre);
        kullaniciDto.setEmail(email);
        if(cinsiyet=="1"){
            kullaniciDto.setCinsiyet(Cinsiyet.ERKEK);
        }else{
            kullaniciDto.setCinsiyet(Cinsiyet.KADIN);
        }
        kullaniciService.createKullanici(kullaniciDto);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }


}
