package ag.agriconnectreleves.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;


// Utilisation de lombok pour générer constructeurs, getters...
// on veut le constrcteur avec TOUS les attributs
@AllArgsConstructor
// on veut le constrcteur SANS argument
@NoArgsConstructor
// on veut les setters pour TOUS les attributs
@Setter
// on veut les getters pour TOUS les attributs
@Getter
/**
 * Objet métier Releve
 */
@Document(collection = "releves")
public class Releve {
    @Id
    private long id;
    @Field
    private LocalDate dateReleve;
    @Field
    private int humitide;
    @Field
    private double temperature;
    @Field
    private Long idCapteur;
}
