package net.paco.accountservice.service;

import net.paco.accountservice.model.BanqueAcount;
import java.util.List;
import java.util.Optional;

public interface BankAcountService {
    BanqueAcount ajouter(BanqueAcount banqueAcount);
    List<BanqueAcount> lister();
    public BanqueAcount cherche(String id);
    public void delete(String id);
    BanqueAcount findBanqueAcountByidcustomer(Long id);
}
