package cours.java.springboot.gestionannoncesapi.repository;

import cours.java.springboot.gestionannoncesapi.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
