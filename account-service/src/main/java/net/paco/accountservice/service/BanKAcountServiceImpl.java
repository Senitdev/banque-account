package net.paco.accountservice.service;
import net.paco.accountservice.clients.CustomerRestClient;
import net.paco.accountservice.model.BanqueAcount;
import net.paco.accountservice.model.Customer;
import net.paco.accountservice.repository.BankAcountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BanKAcountServiceImpl implements  BankAcountService{
     BankAcountRepository bankAcountRepository;
    CustomerRestClient customerRestclient;
    public BanKAcountServiceImpl(BankAcountRepository bankAcountRepository, CustomerRestClient customerRestclient){
        this.bankAcountRepository=bankAcountRepository;
        this.customerRestclient=customerRestclient;
    }
    @Override
    public BanqueAcount ajouter(BanqueAcount banqueAcount) {
        return bankAcountRepository.save(banqueAcount);
    }

    @Override
    public List<BanqueAcount> lister() {
       List<BanqueAcount> account=bankAcountRepository.findAll();
       account.forEach(acc->{
           acc.setCustomer(customerRestclient.findById(acc.getIdcustomer()));
       });
        return account;
    }

    @Override
    public BanqueAcount cherche(String id) {
     //   Long idclient=banqueAcount.getIdcustomer();

        BanqueAcount banqueAcount=bankAcountRepository.findById(id).get();
        Long idclient=banqueAcount.getIdcustomer();
       Customer customers = customerRestclient.findById(idclient);
        banqueAcount.setCustomer(customers);
       return  banqueAcount;
    }

    @Override
    public void delete(String id) {
      bankAcountRepository.deleteById(id);
    }

    @Override
    public BanqueAcount findBanqueAcountByidcustomer(Long id) {
        return bankAcountRepository.findBanqueAcountByidcustomer(id);
    }
}
