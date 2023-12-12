package net.paco.accountservice.model;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer implements Serializable {
    @Id
    private Long id;
    private String firstName;
    private String  lastName;
    private String email;
}
