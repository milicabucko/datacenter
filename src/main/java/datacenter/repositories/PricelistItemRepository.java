package datacenter.repositories;

import datacenter.models.PricelistItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricelistItemRepository extends JpaRepository<PricelistItem, Long> {
}
