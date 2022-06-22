package cours.java.springboot.gestionannoncesapi.services;

import cours.java.springboot.gestionannoncesapi.apiExecption.categorieException;
import cours.java.springboot.gestionannoncesapi.entities.Categorie;
import cours.java.springboot.gestionannoncesapi.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        getCategorieById(id);
        return categorieRepository.findById(id).get();
    }
    //Une fonction qui verifie si uen categorie de par son id existe
    public void getCategorieById(Long id){
        Optional<Categorie> categorieExist=categorieRepository.findById(id);
        if (!categorieExist.isPresent()){
            throw new categorieException(String.format("Cette categrie n'existe pas dans la base de donnees "+id));
        }
    }

    //Une fonction qui verifie si une categorie de meme non existe
    public void getCategorieByLibelle(String libelle){
        Optional<Categorie> categorieExist=categorieRepository.getCategorieByLibelleContains(libelle);
        if (categorieExist.isPresent()){
            throw new categorieException(String.format("Cette categorie existe deja "+libelle));
        }
    }
    public Categorie saveCategorie(Categorie categorie){
            getCategorieByLibelle(categorie.getLibelle());
            return categorieRepository.save(categorie);
    }

    public Categorie editCategorie(Long id,Categorie categorie){
        Categorie categorieEdit=getOneCategorie(id);
        categorieEdit.setLibelle(categorie.getLibelle());
        categorieEdit.setDescrition(categorie.getDescrition());
        try {
            return categorieRepository.save(categorieEdit);
        }catch (Exception e){
            throw new categorieException(String
                    .format(e.getMessage()));
        }

    }
    public void deleteCategorie(Long id){
        try {
            Categorie categorie=getOneCategorie(id);
            categorieRepository.delete(categorie);
        }catch (Exception e){
            throw new categorieException(String
                    .format("Impossible de supprimer cette categorie car elle est detenue par un produit"));
        }

    }

}
