package ag.agriconnectreleves.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

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
@Entity
public class Releve {
    @Id
    private long id;

    private LocalDate dateReleve;

    private int humitide;

    private double temperature;

    private Long idCapteur;
}
