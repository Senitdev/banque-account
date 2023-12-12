package net.paco.customerservice.service;
import java.util.List;
import java.util.Optional;

import net.paco.customerservice.model.Customer;

public interface CustomerService {
    Customer ajouter (Customer customer);
    List<Customer>lister();
     public void supprimer(Long id);
     Optional<Customer>cherche(Long id);


}
