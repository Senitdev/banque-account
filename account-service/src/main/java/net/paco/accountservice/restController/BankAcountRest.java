package net.paco.accountservice.restController;

import net.paco.accountservice.clients.CustomerRestClient;
import net.paco.accountservice.model.BanqueAcount;
import net.paco.accountservice.service.BankAcountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("bankaccount")
public class BankAcountRest {
    private BankAcountService bankAcountService;
    public BankAcountRest(BankAcountService bankAcountService, CustomerRestClient customerService){
        this.bankAcountService=bankAcountService;
    }
    @PostMapping("/ajouter")
    public BanqueAcount add(@RequestBody  BanqueAcount banqueAcount){
        return bankAcountService.ajouter(banqueAcount);
    }
    @GetMapping("/all")
    List<BanqueAcount> listeBanque(){
       return  bankAcountService.lister();
    }
    @GetMapping("/chercher/{id}")
    public BanqueAcount cherche(@PathVariable  String id){
        return bankAcountService.cherche(id);
    }
    @DeleteMapping("/supprime/{id}")
    public void supprime(@PathVariable  String id){
        bankAcountService.delete(id);
    }
     @GetMapping("client/{id}")
    public BanqueAcount chercheClient(@PathVariable Long id){
        return bankAcountService.findBanqueAcountByidcustomer(id);
     }
}
