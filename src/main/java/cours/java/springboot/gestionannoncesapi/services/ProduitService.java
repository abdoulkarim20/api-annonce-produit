package cours.java.springboot.gestionannoncesapi.services;

import cours.java.springboot.gestionannoncesapi.entities.Produit;
import cours.java.springboot.gestionannoncesapi.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    private ProduitRepository produitRepository;
    public ProduitService(ProduitRepository produitRepository){
        this.produitRepository=produitRepository;
    }
    public List<Produit> getAllProduit(){
        return produitRepository.findAll();
    }
    public Produit getOne(Long id){
        return produitRepository.findById(id).orElse(null);
    }
    public Produit saveProduit(Produit produit){
        return produitRepository.save(produit);    }
}
