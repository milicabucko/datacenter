package datacenter.controllers;

import datacenter.models.Constants;
import datacenter.models.ContractItem;
import datacenter.models.Pricelist;
import datacenter.models.PricelistItem;
import datacenter.services.ContractItemService;
import datacenter.services.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
public class PricelistController {

    @Autowired
    private ContractItemService contractItemService;

    @Autowired
    private PricelistService pricelistService;

    @RequestMapping(
            value = "/pricelist/new",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<PricelistItem>> findAll(){

        Collection<ContractItem> contractItems = contractItemService.findAll();

        ArrayList<Pricelist> pricelists = (ArrayList<Pricelist>) pricelistService.findAll();

        Collection<PricelistItem> pricelistItems = new ArrayList<PricelistItem>();
        if (pricelists.size() == 0 || pricelistService.findActivePricelist() == null) {
            for (ContractItem contractItem : contractItems) {
                PricelistItem pricelistItem = new PricelistItem();
                pricelistItem.setContractItem(contractItem);
                pricelistItem.setPrice(0f);
                pricelistItems.add(pricelistItem);
            }
        }
        else {
            Pricelist activePricelist = pricelistService.findActivePricelist();
            for (ContractItem contractItem : contractItems) {
                PricelistItem pricelistItem = new PricelistItem();
                for (PricelistItem pricelistItemTemp : activePricelist.getItems()) {
                    if (pricelistItemTemp.getContractItem().equals(contractItem)){
                        pricelistItem.setPrice(pricelistItemTemp.getPrice());
                        break;
                    }
                    pricelistItem.setPrice(0f);
                }
                pricelistItem.setContractItem(contractItem);
                pricelistItems.add(pricelistItem);
            }
        }
        return new ResponseEntity<Collection<PricelistItem>>(pricelistItems, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/pricelist/new/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pricelist> save(@RequestBody Pricelist pricelistRequest){
        Pricelist pricelist = pricelistRequest;
        pricelist = pricelistService.save(pricelist);
        for (PricelistItem pricelistItem : pricelist.getItems()) {
            pricelistService.saveItem(pricelistItem);
        }
        return new ResponseEntity<Pricelist>(pricelist, HttpStatus.OK);
    }
/*
* Metoda koja se koristi za popunjavanje polja prilikom kreiranja polise.
* Trazi cene iz AKTIVNOG cenovnika vezane za odredjenu grupu rizika.
* Parametar koji se salje metodi je grupa, metoda vraca sve rizike koji se uklapaju.
* */
    @RequestMapping(
            value = "/pricelist/items/findAll/{group}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<PricelistItem>> findAllItemsByItemGroup(@PathVariable String group){
        Collection<PricelistItem> pricelistItems = pricelistService.findAllItemsByItemGroup(group);
        return new ResponseEntity<Collection<PricelistItem>>(pricelistItems, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/pricelist/activate",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pricelist> activatePricelist(){

        //TODO: danasnji dan + 1 sekunda ili milisekunda kako bi se onemogucilo preklapanje datuma
        //TODO: testirati ovu metodu
        String today = "2018-01-21T23:00:01.000Z";
        Pricelist forActivatingPricelist = pricelistService.findActivePricelist(today);

        if (pricelistService.findAll().size() == 0 || forActivatingPricelist == null) {
            System.out.println("Trenutno nema mogucih listi za aktiviranje!");
            return null;
        }

        if (pricelistService.findActivePricelist() == null) {
            forActivatingPricelist.setActive(Constants.ACTIVE_PRICELIST);
            Pricelist activatedPricelist = pricelistService.save(forActivatingPricelist);
            return new ResponseEntity<Pricelist>(activatedPricelist, HttpStatus.OK);
        }
        else {
            Pricelist currentlyActivatedPricelist = pricelistService.findActivePricelist();
            if (currentlyActivatedPricelist.equals(forActivatingPricelist)) {
                return new ResponseEntity<Pricelist>(currentlyActivatedPricelist, HttpStatus.OK);
            }
            else {
                currentlyActivatedPricelist.setActive(false);
                pricelistService.save(currentlyActivatedPricelist);
                forActivatingPricelist.setActive(Constants.ACTIVE_PRICELIST);
                Pricelist activatedPricelist = pricelistService.save(forActivatingPricelist);
                return new ResponseEntity<Pricelist>(activatedPricelist, HttpStatus.OK);
            }
        }

    }

}
