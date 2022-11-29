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
    public String create(@RequestBody KullaniciDto kullaniciDto){
        return kullaniciService.createKullanici(kullaniciDto).toString() ;
    }

    /*
     * /delete/id
     * id >= silinecek kaydın id'si
     * */
}
