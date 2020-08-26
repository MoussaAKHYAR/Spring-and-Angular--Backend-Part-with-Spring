package sn.isi.informatique.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.isi.informatique.entities.Produit;

import java.util.List;

/**
 * Pour autoriser les autres application front (domaine separer) à envoyer les demandes de requete au niveau de notre Api on utilise l'annotation
 * ci dessus
 */
@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    @RestResource(path = "/byDesignation")
    public List<Produit> findByDesignationContains(@Param("mc") String des);
    @RestResource(path = "/byDesignationPage")
    public List<Produit> findByDesignationContains(@Param("mc") String des, Pageable pageable);

}
