package sn.isi.informatique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sn.isi.informatique.dao.ProduitRepository;
import sn.isi.informatique.entities.Produit;

@SpringBootApplication
public class InformatiqueApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;

    //le cas ou on aura besoin d'exposer l'id il faudra utiliser cette anotation : puis utiliser sa fonction exposeIdsFor()
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(InformatiqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Produit.class);
        produitRepository.save(new Produit(null,"Ordinateur Dell",300000,5));
        produitRepository.save(new Produit(null,"Souris",3000,7));
        produitRepository.save(new Produit(null,"Imprimante ",100000,25));

        produitRepository.findAll().forEach(p->{
            System.out.println(p.toString());
        });

    }
}
