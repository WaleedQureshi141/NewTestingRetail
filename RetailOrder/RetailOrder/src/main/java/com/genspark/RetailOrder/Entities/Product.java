package com.genspark.RetailOrder.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "product")
public class Product
{
    @Id
    @Column(name = "prod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "prod_desc")
    private String prodDesc;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "price")
    private int price;

    @ManyToOne  //(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id_fk")
    private Department department;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Order> orders;
}
