package datacenter.repositories;

import datacenter.models.Cenovnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {

    ArrayList<Cenovnik> findByDatumPocetkaLessThanOrderByDatumPocetkaDesc(String danasnjiDatum);

}