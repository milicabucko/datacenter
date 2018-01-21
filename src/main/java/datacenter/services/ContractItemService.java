package datacenter.services;

import datacenter.models.ContractItem;
import datacenter.models.PricelistItem;
import datacenter.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ContractItemService {

    @Autowired
    private ContractItemRepository contractItemRepository;


    public Collection<ContractItem> findAll(String group) {
        return contractItemRepository.findByItemGroup(group);
    }

    public Collection<ContractItem> findAll() {
        return contractItemRepository.findAll();
    }

}
