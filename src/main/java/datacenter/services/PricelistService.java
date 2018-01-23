package datacenter.services;

import datacenter.models.Constants;
import datacenter.models.Pricelist;
import datacenter.models.PricelistItem;
import datacenter.repositories.PricelistItemRepository;
import datacenter.repositories.PricelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PricelistService {

    @Autowired
    private PricelistRepository pricelistRepository;

    @Autowired
    private PricelistItemRepository pricelistItemRepository;

    public Pricelist save(Pricelist pricelist) {
        return pricelistRepository.save(pricelist);
    }

    public PricelistItem saveItem(PricelistItem pricelistItem) {
        return pricelistItemRepository.save(pricelistItem);
    }

    public Collection<Pricelist> findAll() {
        return pricelistRepository.findAll();
    }

    public Pricelist findActivePricelist() {
        return pricelistRepository.findByActive(Constants.ACTIVE_PRICELIST);
    }

    public Collection<PricelistItem> findAllItemsByItemGroup(String itemGroup) {
        return pricelistItemRepository.findByContractItem_ItemGroupAndPricelist_Active(itemGroup, Constants.ACTIVE_PRICELIST);
    }

    public Pricelist findActivePricelist(String today) {
        return pricelistRepository.findByStartDateBeforeAndEndDateAfter(today, today);
    }

}
