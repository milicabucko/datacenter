package datacenter.repositories;

import datacenter.models.Repairment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairmentRepository extends JpaRepository<Repairment, Long> {
}
