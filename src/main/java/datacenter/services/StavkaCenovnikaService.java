package datacenter.services;

import datacenter.models.StavkaCenovnika;
import datacenter.repositories.StavkaCenovnikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StavkaCenovnikaService {

    @Autowired
    private StavkaCenovnikaRepository stavkaCenovnikaRepository;

    public StavkaCenovnika save(StavkaCenovnika stavkaCenovnika) {
        return stavkaCenovnikaRepository.save(stavkaCenovnika);
    }



}
