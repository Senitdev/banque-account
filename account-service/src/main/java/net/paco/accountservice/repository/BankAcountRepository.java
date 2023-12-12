package net.paco.accountservice.repository;

import net.paco.accountservice.model.BanqueAcount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAcountRepository extends JpaRepository<BanqueAcount,String> {
   public  BanqueAcount  findBanqueAcountByidcustomer(Long id);
}
