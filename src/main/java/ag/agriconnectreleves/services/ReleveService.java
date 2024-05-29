package ag.agriconnectreleves.services;

import ag.agriconnectreleves.entities.Releve;
import ag.agriconnectreleves.repo.ReleveRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ReleveService {
    private final ReleveRepository repo;

    public ReleveService(ReleveRepository repo) {
        this.repo = repo;
    }

    public Iterable<Releve> getReleves(){
        return repo.findAll();
    }

    public Releve getReleve(long id){
        return repo.findById(id).orElse(null);
    }

    public Iterable<Releve> getRelevesParCapteur(long idCapteur){
        return repo.findAllByIdCapteur(idCapteur);
    }

    public Releve addReleve(@RequestBody Releve releve){
        return repo.save(releve);
    }

}