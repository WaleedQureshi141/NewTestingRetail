package com.genspark.RetailOrder.Services;

import com.genspark.RetailOrder.DTOs.OrderDTO;
import com.genspark.RetailOrder.Entities.Order;
import com.genspark.RetailOrder.Entities.Product;

import java.util.List;

public interface OrderService
{
    List<Product> getProductsInOrder(int orderId);
    List<Order> getOrderByUserId(int userId);
    List<Order> getAllOrders();
    String addProdToOrder(OrderDTO orderDTO);
    String changeOrderStatus(OrderDTO orderDTO);
    Order createOrder(OrderDTO orderDTO);
    String deleteProdFromOrder(int orderId, int prodId);
}
