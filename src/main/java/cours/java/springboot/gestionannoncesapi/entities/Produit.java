package cours.java.springboot.gestionannoncesapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "produits")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String produitName;
    private String photo;
    private Double prix;
    private String description;
    @ManyToOne
    private Categorie categorie;
}
