package com.springfilmproject.springfilmproject.Kullanici;

import com.springfilmproject.springfilmproject.exception.CoreMessageException;
import com.springfilmproject.springfilmproject.model.Kullanici;
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
    public String login(@RequestBody KullaniciAuthDto kullaniciAuthDto){
        return kullaniciService.kullaniciVarMi(kullaniciAuthDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return kullaniciService.kullaniciSil(id);
    }

    @PostMapping("/create")
    public String create(@RequestBody KullaniciDto kullaniciDto){
        String vValue = "";
        try {
            vValue=   kullaniciService.createKullanici(kullaniciDto).toString() ;
        } catch (CoreMessageException e) {
            e.printStackTrace();
        }
        return vValue;
    }

    /*
     * /delete/id
     * id >= silinecek kaydın id'si
     * */
}
