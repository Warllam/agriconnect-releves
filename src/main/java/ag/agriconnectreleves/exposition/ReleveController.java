package ag.agriconnectreleves.exposition;

import ag.agriconnectreleves.entities.Releve;
import ag.agriconnectreleves.services.ReleveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Iterable<Releve> getRelevesParCapteur(@PathVariable("id") Long idCapteur) {
        logger.info("Releve : demande des relevés pour le capteur id:{}", idCapteur);
        return releveService.getRelevesParCapteur(idCapteur);
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
