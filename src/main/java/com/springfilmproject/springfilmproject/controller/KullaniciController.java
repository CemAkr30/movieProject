package com.springfilmproject.springfilmproject.controller;

import com.springfilmproject.springfilmproject.dto.KullaniciAuthDto;
import com.springfilmproject.springfilmproject.dto.KullaniciDto;
import com.springfilmproject.springfilmproject.enums.Cinsiyet;
import com.springfilmproject.springfilmproject.model.Kullanici;
import com.springfilmproject.springfilmproject.service.KullaniciService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/kullanici")
@CrossOrigin("*")
public class KullaniciController {

    private final KullaniciService kullaniciService;

    public KullaniciController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    @GetMapping("/all")
    public List<Kullanici> getAll(){
        return kullaniciService.getButunKullanici();
    }

    @GetMapping("/{kullaniciId}")
    public Kullanici get(@PathVariable Long kullaniciId){
        return kullaniciService.getKullanici(kullaniciId);
    }

    @PostMapping("/login")
    public long login(@RequestBody KullaniciAuthDto kullaniciAuthDto){
        return kullaniciService.kullaniciVarMi(kullaniciAuthDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return kullaniciService.kullaniciSil(id);
    }

    @PostMapping("/create")
    public String create(@RequestBody Kullanici kullanici){
        return "";
        /* JSONObject obj = null;
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
        }*/
    }

    /*
     * /delete/id
     * id >= silinecek kaydın id'si
     * */
}
