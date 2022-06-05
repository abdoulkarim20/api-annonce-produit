package cours.java.springboot.gestionannoncesapi.controller;

import cours.java.springboot.gestionannoncesapi.entities.Categorie;
import cours.java.springboot.gestionannoncesapi.services.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorie/api/v1")
@CrossOrigin(origins = "*")
public class CategorieController {
    private CategorieService categorieService;
    public CategorieController(CategorieService categorieService){
        this.categorieService=categorieService;
    }
    /*La methode de recuperation de tous les categories*/
    @GetMapping("/all")
    public List<Categorie> categories(){
        return categorieService.getAllCategorie();
    }
    /*La methode de recuperation d'une categorie*/
    @GetMapping("/get/{id}")
    public Categorie getOne(@PathVariable Long id){
        return categorieService.getOneCategorie(id);
    }
    /*La methode d'ajout d'un categorie*/
    @PostMapping("/save")
    public Categorie save(@RequestBody Categorie categorie){
        categorieService.saveCategorie(categorie);
        return categorie;
    }
    /*La methode de modification d'un categorie*/
    @PutMapping("/edit/{id}")
    public Categorie update(@PathVariable Long id,@RequestBody Categorie categorie){
        return categorieService.editCategorie(id,categorie);
    }
    /*La methode de suppression d'un categorie*/
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        categorieService.deleteCategorie(id);
    }
}
