package com.genspark.RetailOrder.DTOs;

import com.genspark.RetailOrder.Entities.Product;
import com.genspark.RetailOrder.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO
{
    private int orderId;
    private String status;
    private User user;
    private List<Product> product;

}
