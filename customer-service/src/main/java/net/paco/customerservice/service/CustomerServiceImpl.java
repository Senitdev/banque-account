package net.paco.customerservice.service;

import net.paco.customerservice.clients.BankRestClients;
import net.paco.customerservice.model.BanqueAcount;
import net.paco.customerservice.model.Customer;
import net.paco.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private BankRestClients bankRestClients;
    public CustomerServiceImpl(CustomerRepository customerRepository,BankRestClients bankRestClients){
        this.customerRepository=customerRepository;
        this.bankRestClients=bankRestClients;
    }
    @Override
    public Customer ajouter(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> lister() {
        return customerRepository.findAll();
    }

    @Override
    public void supprimer(Long id) {
       /*Verifier si le client à un compte bancaire*/
        BanqueAcount banqueAcount=bankRestClients.findBanqueAcountByidCustomer(id);
        if(banqueAcount!=null && banqueAcount.getAccountId()!=null){
            throw  new ClassCastException("Ce client  posséde un compte bancaire");
        }
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> cherche(Long id) {
        return customerRepository.findById(id);
    }
}
