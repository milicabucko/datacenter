package datacenter.repositories;

import datacenter.models.StavkaOsiguranja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StavkaOsiguranjaRepository extends JpaRepository<StavkaOsiguranja, Long> {

    Collection<StavkaOsiguranja> findByKategorija(String kategorija);

}
