package com.genspark.RetailOrder.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "orders")
public class Order
{
    @Id
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_prod",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "prod_id")
    )
    private List<Product> products;
}
