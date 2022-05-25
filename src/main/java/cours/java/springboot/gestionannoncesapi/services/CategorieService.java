package cours.java.springboot.gestionannoncesapi.services;

import cours.java.springboot.gestionannoncesapi.entities.Categorie;
import cours.java.springboot.gestionannoncesapi.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    private CategorieRepository categorieRepository;
    public CategorieService(CategorieRepository categorieRepository){
        this.categorieRepository=categorieRepository;
    }
    public List<Categorie> getAllCategorie(){
        return categorieRepository.findAll();
    }
    public Categorie getOneCategorie(Long id){
        return categorieRepository.findById(id).get();
    }
    public Categorie saveCategorie(Categorie categorie){
        return categorieRepository.save(categorie);
    }
    public Categorie editCategorie(Long id,Categorie categorie){
        Categorie categorieEdit=getOneCategorie(id);
        categorieEdit.setLibelle(categorie.getLibelle());
        categorieEdit.setDescrition(categorie.getDescrition());
        return categorieRepository.save(categorieEdit);
    }
    public void deleteCategorie(Long id){
        Categorie categorie=getOneCategorie(id);
        categorieRepository.delete(categorie);
    }

}
