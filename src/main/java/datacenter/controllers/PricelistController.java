package datacenter.controllers;

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
import java.util.Collection;

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
        Collection<PricelistItem> pricelistItems = new ArrayList<PricelistItem>();
        for (ContractItem contractItem: contractItems) {
            PricelistItem pricelistItem = new PricelistItem();
            pricelistItem.setContractItem(contractItem);
            pricelistItem.setPrice(0f);
            pricelistItems.add(pricelistItem);
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

}
