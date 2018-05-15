package datacenter.services;

import datacenter.models.StavkaOsiguranja;
import datacenter.repositories.StavkaOsiguranjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StavkaOsiguranjaService {

    @Autowired
    private StavkaOsiguranjaRepository stavkaOsiguranjaRepository;


    public StavkaOsiguranja save(StavkaOsiguranja stavka) {
        return stavkaOsiguranjaRepository.save(stavka);
    }

    public Collection<StavkaOsiguranja> findAll() {
        return stavkaOsiguranjaRepository.findAll();
    }

    public Collection<StavkaOsiguranja> findByKategorija(String kategorija) {
        return stavkaOsiguranjaRepository.findByKategorija(kategorija);
    }

    public void delete(Long id) {
        stavkaOsiguranjaRepository.delete(id);
    }
}
