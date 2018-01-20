package datacenter.repositories;

import datacenter.models.ContractItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ContractItemRepository extends JpaRepository<ContractItem, Long> {


   Collection<ContractItem> findByItemGroup(String group);
}
