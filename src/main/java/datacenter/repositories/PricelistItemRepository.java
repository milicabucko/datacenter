package datacenter.repositories;

import datacenter.models.Pricelist;
import datacenter.models.PricelistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PricelistItemRepository extends JpaRepository<PricelistItem, Long> {

    Collection<PricelistItem> findByContractItem_ItemGroupAndPricelist_Active(String itemGroup, Boolean active);
}
