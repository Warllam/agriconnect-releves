package ag.agriconnectreleves.repo;

import ag.agriconnectreleves.entities.Releve;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository pour la gestion des relevés dans MongoDB.
 */
@Repository
public interface ReleveRepository extends MongoRepository<Releve, Long> {
    /**
     * Trouver tous les relevés par l'identifiant du capteur.
     * @param idCapteur Identifiant du capteur
     * @return Liste des relevés
     */
    Optional<List<Releve>> findAllByIdCapteur(Long idCapteur);


    /**
     * Trouve pour un capteur donné à une date spécifique tous les relevés.
     * @param idCapteur ID
     * @param date Date spécifique
     * @return List of readings
     */
    Optional<List<Releve>> findByIdCapteurAndDateReleve(Long idCapteur, LocalDate date);
}

