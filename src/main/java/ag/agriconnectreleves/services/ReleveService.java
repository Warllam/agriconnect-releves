package ag.agriconnectreleves.services;

import ag.agriconnectreleves.entities.Releve;
import ag.agriconnectreleves.repo.ReleveRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Optional<List<Releve>> getRelevesParCapteur(Long idCapteur){
        return repo.findAllByIdCapteur(idCapteur);
    }

    public Optional<List<Releve>> getRelevesParCapteurEtParJour(Long idCapteur, LocalDate date){
        return repo.findByIdCapteurAndDateReleve(idCapteur, date);
    }

    public Releve addReleve(@RequestBody Releve releve){
        return repo.save(releve);
    }

    public void deleteReleve(long id){
        repo.deleteById(id);
    }

}