package net.paco.customerservice.restcontroller;

import net.paco.customerservice.model.Customer;
import net.paco.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/customer")
public class CustomerRest {
    private CustomerService customerService;
    public CustomerRest(CustomerService customerService){

        this.customerService=customerService;
    }
    //ajouter && modification
    @PostMapping("/ajout")
    public Customer add(@RequestBody  Customer customer){
        return customerService.ajouter(customer);
    }
    //lister
    @GetMapping()
    List<Customer> allCustomer(){
        return customerService.lister();
    }
    //retourner un customer par son id
    @GetMapping("/chercher/{id}")
    Optional<Customer>findbyId(@PathVariable  Long id){
        return customerService.cherche(id);
    }
    //Supprimer un Customer
    @DeleteMapping("/supprimer/{id}")
    public void delete(@PathVariable  Long id){

        customerService.supprimer(id);
    }

}
