package cours.java.springboot.gestionannoncesapi.controller;

import cours.java.springboot.gestionannoncesapi.entities.Categorie;
import cours.java.springboot.gestionannoncesapi.services.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {
    CategorieService categorieService;
    public CategorieController(CategorieService categorieService){
        this.categorieService=categorieService;
    }
    @GetMapping("/categories")
    public List<Categorie> categories(){
        return categorieService.getAllCategorie();
    }
    @PostMapping("/categorie/save")
    public Categorie save(@RequestBody Categorie categorie){
        categorieService.saveCategorie(categorie);
        return categorie;
    }
    @PutMapping("/categorie/edit/{id}")
    public Categorie update(@PathVariable Long id,@RequestBody Categorie categorie){
        return categorieService.editCategorie(id,categorie);
    }

    @DeleteMapping("/categorie/delete/{id}")
    public void delete(@PathVariable Long id){
        categorieService.deleteCategorie(id);
    }
}
