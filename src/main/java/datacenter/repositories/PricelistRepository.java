package datacenter.repositories;

import datacenter.models.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PricelistRepository extends JpaRepository<Pricelist, Long>{

    Pricelist findByActive(Boolean active);
    Pricelist findByStartDateBeforeAndEndDateAfter(String today, String today1);
}
