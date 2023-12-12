package net.paco.accountservice.model;

import jakarta.persistence.*;
import lombok.*;
import net.paco.accountservice.enums.AcountType;

import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BanqueAcount implements Serializable {
    @Id
    public String accountId;
    public LocalDate createdAt;
    private  String currency;
    @Enumerated(EnumType.STRING)
    private AcountType acountType;
    @Transient
    private Customer customer;
    private Long idcustomer;
    private Integer balance;
}
