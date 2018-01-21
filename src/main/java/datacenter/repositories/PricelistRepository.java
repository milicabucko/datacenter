package datacenter.repositories;

import datacenter.models.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricelistRepository extends JpaRepository<Pricelist, Long>{
}
