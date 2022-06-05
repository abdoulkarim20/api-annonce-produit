package cours.java.springboot.gestionannoncesapi.repository;

import cours.java.springboot.gestionannoncesapi.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    public Optional<Categorie> getCategorieByLibelleContains(String libelle);
}
