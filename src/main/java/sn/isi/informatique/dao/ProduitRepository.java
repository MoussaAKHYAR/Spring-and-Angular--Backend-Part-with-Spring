package sn.isi.informatique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.informatique.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
