package datacenter.services;

import datacenter.models.Pricelist;
import datacenter.models.PricelistItem;
import datacenter.repositories.PricelistItemRepository;
import datacenter.repositories.PricelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
