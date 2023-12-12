package net.paco.customerservice;
import net.paco.customerservice.model.Customer;
import net.paco.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
   @Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return  args -> {
			Customer customer=new Customer();
			customer.setFirstName("Pape");
			customer.setLastName("Toure");
			customer.setEmail("Pape@gmail.com");
			customerRepository.save(customer);
			Customer customer2=new Customer();
			customer2.setFirstName("Fatou");
			customer2.setLastName("Toure");
			customer2.setEmail("fatou@gmail.com");
			customerRepository.save(customer2);
			Customer customer3=new Customer();
			customer3.setFirstName("Omar");
			customer3.setLastName("Diop");
			customer3.setEmail("omar@gmail.com");
			customerRepository.save(customer3);
		};
  }
}