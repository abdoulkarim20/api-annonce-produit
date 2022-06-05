package cours.java.springboot.gestionannoncesapi.services;

import cours.java.springboot.gestionannoncesapi.entities.Categorie;
import cours.java.springboot.gestionannoncesapi.entities.Produit;
import cours.java.springboot.gestionannoncesapi.repository.CategorieRepository;
import cours.java.springboot.gestionannoncesapi.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    private ProduitRepository produitRepository;
    private CategorieRepository categorieRepository;
    public ProduitService(ProduitRepository produitRepository,
                          CategorieRepository categorieRepository){
        this.produitRepository=produitRepository;
        this.categorieRepository=categorieRepository;
    }
    public List<Produit> getAllProduit(){
        return produitRepository.findAll();
    }
    public Produit getOne(Long id){
        return produitRepository.findById(id).orElse(null);//        p.setCategorie(categorieRepository.getById(produit.));

    }
    public Produit saveProduit(Produit produit){
        return produitRepository.save(produit);}
    public void deleteProduit(Long id){
        Produit produit=getOne(id);
        produitRepository.delete(produit);
    }
    public Produit editProduit(Long id,Produit produit){
        Produit p=getOne(id);
        p.setProduitName(produit.getProduitName());
        p.setPhoto(produit.getPhoto());
        p.setCategorie(produit.getCategorie());
        p.setPhoto(produit.getPhoto());
        p.setPrix(produit.getPrix());
        return produitRepository.save(p);
    }
}
