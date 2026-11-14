package net.noureddine.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.noureddine.billingservice.model.Customer;

import java.util.Date;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
@Id
@GeneratedValue
    private Long id;
    private Date billinDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
