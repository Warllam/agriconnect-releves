package ag.agriconnectreleves.repo;

import ag.agriconnectreleves.entities.Releve;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    List<Releve> findAllByIdCapteur(Long idCapteur);
}
