package ag.agriconnectreleves.exposition;

import ag.agriconnectreleves.entities.Releve;
import ag.agriconnectreleves.services.ReleveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Service d'exposition REST des relevés.
 * URL /releves exposée.
 */
@RestController
@RequestMapping("/api/releves")
public class ReleveController {
    Logger logger = LoggerFactory.getLogger(ReleveController.class);

    ReleveService releveService;

    public ReleveController(ReleveService releveService) {
        this.releveService = releveService;
    }

    /**
     * GET 1 relevé
     * @param id de relevé
     * @return Relevé converti en JSON
     */
    @GetMapping("/{id}")
    public Releve getReleve(@PathVariable("id") long id) {
        logger.info("Releve : demande d'un relevé avec id:{}", id);
        return releveService.getReleve(id);
    }

    /**
     * GET liste des relevés par idCapteur
     * @return liste des relevés en JSON. [] si aucun relevé.
     */
    @GetMapping("/capteur/{id}")
    public ResponseEntity<List<Releve>> getRelevesParCapteur(@PathVariable("id") Long idCapteur) {
        logger.info("Releve : demande des relevés pour le capteur id:{}", idCapteur);
        if (releveService.getRelevesParCapteur(idCapteur).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(releveService.getRelevesParCapteur(idCapteur).get());
    }

    /**
     * GET liste des relevés par idCapteur et Jour
     * @return liste des relevés en JSON. [] si aucun relevé.
     */
    @GetMapping("/capteur/{id}/{date}")
    public ResponseEntity<List<Releve>> getRelevesParCapteurEtParJour(@PathVariable Long id, @PathVariable LocalDate date) {
        logger.info("Releve : demande des relevés pour le capteur id: {} à la date du {}", id, date);
        if (releveService.getRelevesParCapteurEtParJour(id, date).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(releveService.getRelevesParCapteurEtParJour(id, date).get());
    }

    /**
     * GET liste de tous les relevés
     * @return liste des relevés en JSON. [] si aucun relevé.
     */
    @GetMapping("")
    public Iterable<Releve> getReleves() {
        logger.info("Releve : demande de la liste de tous les relevés");
        return releveService.getReleves();
    }

    /**
     * POST un relevé
     * @param releve Relevé à ajouter (import JSON)
     * @return relevé ajouté
     */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Releve addReleve(@RequestBody Releve releve) {
        logger.info("Releve : création d'un relevé avec id:{}", releve.getId());
        return releveService.addReleve(releve);
    }
}
