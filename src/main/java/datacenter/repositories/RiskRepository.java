package datacenter.repositories;

import datacenter.models.Risk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskRepository extends JpaRepository<Risk, Long> {
}
