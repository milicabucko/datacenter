package datacenter.controllers;

import datacenter.services.ContractItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContractItemController {

    @Autowired
    private ContractItemService contractItemService;

    @GetMapping(value = "/contract/items/findAll/{itemName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object[] findAll(@PathVariable String itemName) {
        Object[] contractItems = contractItemService.findAll(itemName);
        return contractItems;
    }
}
