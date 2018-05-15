package datacenter.controllers;

import datacenter.models.Cenovnik;
import datacenter.models.StavkaCenovnika;
import datacenter.services.CenovnikService;
import datacenter.services.DateService;
import datacenter.services.StavkaCenovnikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CenovnikController {

    @Autowired
    private CenovnikService cenovnikService;

    @Autowired
    private StavkaCenovnikaService stavkaCenovnikaService;

    @RequestMapping(
            value = "/cenovnik/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Cenovnik> save(@RequestBody Cenovnik c) throws ParseException {
        c.setDatumPocetka(DateService.getFormattedDateUniversal(c.getDatumPocetka()));
        Cenovnik cenovnik = cenovnikService.save(c);
        return new ResponseEntity<>(cenovnik, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/cenovnik/stavka/save/{cenovnikId}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StavkaCenovnika> saveStavka(@RequestBody StavkaCenovnika stavka, @PathVariable Long cenovnikId) {
        stavka.setId(null);
        Cenovnik cenovnik = cenovnikService.findOne(cenovnikId);
        stavka.setCenovnik(cenovnik);
        StavkaCenovnika stavkaCenovnika = stavkaCenovnikaService.save(stavka);
        return new ResponseEntity<>(stavkaCenovnika, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/cenovnik/aktivan",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Cenovnik> aktivan() throws ParseException {
        Cenovnik cenovnik = cenovnikService.getActive("20180511");
        return new ResponseEntity<>(cenovnik, HttpStatus.OK);
    }


}
