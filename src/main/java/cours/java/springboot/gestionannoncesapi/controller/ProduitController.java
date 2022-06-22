package cours.java.springboot.gestionannoncesapi.controller;

import cours.java.springboot.gestionannoncesapi.entities.Produit;
import cours.java.springboot.gestionannoncesapi.services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produit/api/v1")
@CrossOrigin(origins = "*")
public class ProduitController {
    private ProduitService produitService;
    public ProduitController(ProduitService produitService){
        this.produitService=produitService;
    }
    /*recuperation de tous les produits*/
    @GetMapping("/all")
    public List<Produit> getAll(){
        return produitService.getAllProduit();
    }
    /*recuperation un produit*/
    @GetMapping("/produit/{id}")
    public Produit getOne(@PathVariable Long id){
        return produitService.getOne(id);
    }
    /*enregistrer un produit*/
    @PostMapping("/save")
    public Produit save(@RequestBody Produit produit){
        produitService.saveProduit(produit);
        return produit;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        produitService.deleteProduit(id);
    }
    @PutMapping("/edit/{id}")
    public Produit edit(@PathVariable Long id,@RequestBody Produit produit){
       return produitService.editProduit(id,produit);
    }
}
