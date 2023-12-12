package net.paco.customerservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.paco.customerservice.model.BanqueAcount;
import net.paco.customerservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "BANKACCOUNT-SERVICE")
public interface BankRestClients {
     @GetMapping("/bankaccount/client/{id}")
     @CircuitBreaker(name = "bankaccountService", fallbackMethod ="getDefaultMessage")
    public BanqueAcount findBanqueAcountByidCustomer(@PathVariable Long id);
     default  Customer getDefaultMessage(Long id,Exception exception){
       Customer customer=new Customer();
       customer.setEmail("Service not available");
       customer.setFirstName("Pas disponible");
       customer.setLastName("No disponible");
         return customer;

     }
}
