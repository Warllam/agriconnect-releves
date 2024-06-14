package ag.agriconnectreleves.services;

import ag.agriconnectreleves.entities.Releve;
import ag.agriconnectreleves.repo.ReleveRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

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

    public Iterable<Releve> getRelevesParCapteur(Long idCapteur){
        return repo.findAllByIdCapteur(idCapteur);
    }

    public List<Releve> getRelevesParCapteurEtParJour(Long idCapteur, LocalDate date){
        return repo.findByIdCapteurAndDateReleve(idCapteur, date);
    }

    public Releve addReleve(@RequestBody Releve releve){
        return repo.save(releve);
    }

}