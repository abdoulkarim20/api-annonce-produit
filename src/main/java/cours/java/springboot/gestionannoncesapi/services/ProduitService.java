package cours.java.springboot.gestionannoncesapi.services;

import cours.java.springboot.gestionannoncesapi.repository.ProduitRepository;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {
    private ProduitRepository produitRepository;
    public ProduitService(ProduitRepository produitRepository){
        this.produitRepository=produitRepository;
    }
}
