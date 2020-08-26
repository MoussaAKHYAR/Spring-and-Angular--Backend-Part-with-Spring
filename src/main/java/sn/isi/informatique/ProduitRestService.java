package sn.isi.informatique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.isi.informatique.dao.ProduitRepository;
import sn.isi.informatique.entities.Produit;

import java.util.List;

/**
 * Cette classe nous permet de creer un web service sans passer par Spring data rest
 * pour que desfois on puisse appeler une methode dans la couche metier dans laquelle nous avons des traitements
 * assez complexe d'ou SpringDataRest ne sera pas suffisant.
 */

@RestController
public class ProduitRestService {
    @Autowired
    private ProduitRepository produitRepository;
    @GetMapping(value = "/listeProduits")
    public List<Produit> listeProduits(){
        return produitRepository.findAll();
    }

    /**
     * Pour consulter un seul produit
     */
    @GetMapping(value = "/listeProduits/{id}")
    public Produit listeProduits(@PathVariable(name = "id") Long id){
        return produitRepository.findById(id).get();
    }

    /**
     * Pour MAJ un  produit on utilise cette methode
     * mais pour recuperer les données en format JSON on utilise l'annotation @RequestBody
     */
    @PutMapping(value = "/listeProduits/{id}")
    public Produit update(@PathVariable(name = "id") Long id, @RequestBody Produit p){
        p.setId(id);
        return produitRepository.save(p);
    }

    /**
     * Pour inserer un  produit on utilise cette methode
     * mais pour recuperer les données en format JSON on utilise l'annotation @RequestBody
     */
    @PostMapping(value = "/listeProduits")
    public Produit save(@RequestBody Produit p){
        return produitRepository.save(p);
    }

    /**
     * Pour Supprimer un  produit on utilise cette methode
     */
    @DeleteMapping(value = "/listeProduits/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        produitRepository.deleteById(id);
    }
}
