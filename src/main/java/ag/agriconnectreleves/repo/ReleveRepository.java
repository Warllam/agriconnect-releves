package ag.agriconnectreleves.repo;

import ag.agriconnectreleves.entities.Releve;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Repository pour la gestion des relevés dans MongoDB.
 */
@EnableDiscoveryClient
@Component
public interface ReleveRepository extends MongoRepository<Releve, Long> {
    /**
     * Trouver tous les relevés par l'identifiant du capteur.
     * @param idCapteur Identifiant du capteur
     * @return Liste des relevés
     */
    List<Releve> findAllByIdCapteur(Long idCapteur);
}
