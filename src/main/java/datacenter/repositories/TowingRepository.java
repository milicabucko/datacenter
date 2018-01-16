package datacenter.repositories;

import datacenter.models.Towing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TowingRepository extends JpaRepository<Towing, Long> {
}
