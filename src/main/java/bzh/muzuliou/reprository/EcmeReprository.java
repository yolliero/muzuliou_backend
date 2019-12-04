package bzh.muzuliou.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bzh.muzuliou.entity.Ecme;

@Repository
public interface EcmeReprository extends JpaRepository<Ecme,Integer> {


	
}
