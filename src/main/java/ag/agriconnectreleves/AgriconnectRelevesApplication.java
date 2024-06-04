package ag.agriconnectreleves;

import ag.agriconnectreleves.entities.Releve;
import ag.agriconnectreleves.repo.ReleveRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AgriconnectRelevesApplication implements CommandLineRunner {

    private final ReleveRepository releveRepository;

    public AgriconnectRelevesApplication(ReleveRepository releveRepository) {
        this.releveRepository = releveRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AgriconnectRelevesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Releve r1 = new Releve();
        //this.releveRepository.save(r1);
    }
}
