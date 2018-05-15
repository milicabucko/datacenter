package datacenter.controllers;

import datacenter.models.StavkaOsiguranja;
import datacenter.services.StavkaOsiguranjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StavkaOsiguranjaController {

    @Autowired
    private StavkaOsiguranjaService stavkaOsiguranjaService;

    @RequestMapping(
            value = "/stavka/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StavkaOsiguranja> save(@RequestBody StavkaOsiguranja stavka) {
        StavkaOsiguranja stavkaOsiguranja = stavkaOsiguranjaService.save(stavka);
        return new ResponseEntity<>(stavkaOsiguranja, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/stavka/delete/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> delete(Long id) {
        stavkaOsiguranjaService.delete(id);
        return new ResponseEntity<>("USPESNO OBRISANA!", HttpStatus.OK);
    }

    @RequestMapping(
            value = "/stavka/getAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<StavkaOsiguranja>> getAll() {
        Collection<StavkaOsiguranja> stavke = stavkaOsiguranjaService.findAll();
        return new ResponseEntity<>(stavke, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/stavka/findByKategorija/{kategorija}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<StavkaOsiguranja>> findByKategorija(@PathVariable String kategorija) {
        Collection<StavkaOsiguranja> stavke = stavkaOsiguranjaService.findByKategorija(kategorija);
        return new ResponseEntity<>(stavke, HttpStatus.OK);
    }

}
