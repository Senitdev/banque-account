package net.paco.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.paco.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient("CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customer")
    @CircuitBreaker(name="customerService",fallbackMethod = "getDefaultAllCustomer")
    List<CustomerRestClient> lister();
    @GetMapping("/customer/chercher/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    public Customer findById(@PathVariable  Long id);
    default   Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstName("Not available");
        customer.setLastName("Not available");
        customer.setEmail("Not available");
        return customer;
    }
    default  List<Customer> getDefaultAllCustomer(Exception exception){
        return List.of();
    }
}
