package ag.agriconnectreleves.exposition;

import ag.agriconnectreleves.entities.Releve;
import ag.agriconnectreleves.repo.ReleveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Service d'exposition REST des relevés.
 * URL /releves exposée.
 */
@RestController
@RequestMapping("/api/releves")
public class ReleveController {
    Logger logger = LoggerFactory.getLogger(ReleveController.class);

    @Autowired
    private ReleveRepository repo;

    /**
     * GET 1 relevé
     * @param id de relevé
     * @return Relevé converti en JSON
     */
    @GetMapping("/{id}")
    public Releve getReleve(@PathVariable("id") long id) {
        logger.info("Releve : demande d'un relevé avec id:{}", id);
        return repo.findById(id).orElse(null);
    }

    /**
     * GET liste des relevés par idCapteur
     * @return liste des relevés en JSON. [] si aucun relevé.
     */
    @GetMapping("")
    public Iterable<Releve> getRelevesParCapteur(@RequestParam("capteur") Long idCapteur) {
        logger.info("Releve : demande des relevés pour le capteur id:{}", idCapteur);
        return repo.findAllByIdCapteur(idCapteur);
    }

    /**
     * GET liste de tous les relevés
     * @return liste des relevés en JSON. [] si aucun relevé.
     */
    @GetMapping("/all")
    public Iterable<Releve> getReleves() {
        logger.info("Releve : demande de la liste de tous les relevés");
        return repo.findAll();
    }

    /**
     * POST un relevé
     * @param releve Relevé à ajouter (import JSON)
     * @return relevé ajouté
     */
    @PostMapping("")
    public Releve postReleve(@RequestBody Releve releve) {
        logger.info("Releve : création d'un relevé avec id:{}", releve.getId());
        return repo.save(releve);
    }

}
