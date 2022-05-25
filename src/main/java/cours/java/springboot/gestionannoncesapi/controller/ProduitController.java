package cours.java.springboot.gestionannoncesapi.controller;

import cours.java.springboot.gestionannoncesapi.entities.Produit;
import cours.java.springboot.gestionannoncesapi.services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {
    private ProduitService produitService;
    public ProduitController(ProduitService produitService){
        this.produitService=produitService;
    }
    /*recuperation de tous les produits*/
    @GetMapping("/produits")
    public List<Produit> getAll(){
        return produitService.getAllProduit();
    }
    /*recuperation un produit*/
    @GetMapping("/produit/{id}")
    public Produit getOne(@PathVariable Long id){
        return produitService.getOne(id);
    }
    /*enregistrer un produit*/
    @PostMapping("/produit/save")
    public Produit save(@RequestBody Produit produit){
        produitService.saveProduit(produit);
        return produit;
    }
}
