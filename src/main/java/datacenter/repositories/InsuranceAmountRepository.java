package datacenter.repositories;

import datacenter.models.InsuranceAmount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceAmountRepository extends JpaRepository<InsuranceAmount, Long> {
}
