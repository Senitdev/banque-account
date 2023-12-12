package net.paco.accountservice;

import net.paco.accountservice.config.GlobalConfig;
import net.paco.accountservice.enums.AcountType;
import net.paco.accountservice.model.BanqueAcount;
import net.paco.accountservice.repository.BankAcountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.rmi.server.UID;
import java.time.LocalDate;
import java.util.UUID;
@EnableConfigurationProperties(GlobalConfig.class)
@EnableFeignClients
@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
   @Bean
	CommandLineRunner commandLineRunner(BankAcountRepository bankAcountRepository){
		return args -> {
			BanqueAcount banqueAcount=new BanqueAcount();
			banqueAcount.setAccountId(UUID.randomUUID().toString());
			banqueAcount.setAcountType(AcountType.CURRENT_ACCOUNT);
			banqueAcount.setIdcustomer(Long.valueOf(1));
			banqueAcount.setCreatedAt(LocalDate.now());
			banqueAcount.setCurrency("MAD");
			banqueAcount.setBalance(18000);
			bankAcountRepository.save(banqueAcount);
			BanqueAcount banqueAcount2=new BanqueAcount();
			banqueAcount2.setAccountId(UUID.randomUUID().toString());
			banqueAcount2.setAcountType(AcountType.CURRENT_ACCOUNT);
			banqueAcount2.setIdcustomer(Long.valueOf(2));
			banqueAcount2.setCreatedAt(LocalDate.now());
			banqueAcount2.setCurrency("MAD");
			banqueAcount2.setBalance(25000);
			bankAcountRepository.save(banqueAcount2);

		};
   }
}
