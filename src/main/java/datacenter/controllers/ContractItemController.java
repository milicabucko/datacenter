package datacenter.controllers;

import datacenter.models.ContractItem;
import datacenter.services.ContractItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class ContractItemController {

    @Autowired
    private ContractItemService contractItemService;

    @RequestMapping(
            value = "/contract/items/findAll/{group}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ContractItem>> findAll (@PathVariable String group){
        Collection<ContractItem> contractItems = contractItemService.findAll(group);
        return new ResponseEntity<Collection<ContractItem>>(contractItems, HttpStatus.OK);
    }

}
