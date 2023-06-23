package com.genspark.RetailOrder.Services;

import com.genspark.RetailOrder.DTOs.OrderDTO;
import com.genspark.RetailOrder.Entities.Order;
import com.genspark.RetailOrder.Entities.Product;
import com.genspark.RetailOrder.Repostitories.OrderRepo;
import com.genspark.RetailOrder.Repostitories.ProductRepo;
import com.genspark.RetailOrder.Repostitories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Product> getProductsInOrder(int orderId)
    {
        List<Integer> order_prod = orderRepo.getProdsRelOrder(orderId);
//        int size = order_prod.size();

        List<Product> prods = orderRepo.getProdsInOrder(order_prod);

        return prods;
    }

    @Override
    public List<Order> getOrderByUserId(int userId) {
        return orderRepo.findOrdersByUserId(userId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public String addProdToOrder(OrderDTO orderDTO)
    {
        Order order = new Order();

        order.setOrderId(orderDTO.getOrderId());
        order.setStatus(orderDTO.getStatus());
        order.setUser(orderDTO.getUser());
        order.setProducts(orderDTO.getProduct());

        orderRepo.save(order);

        return "order updated";
    }

    @Override
    public String changeOrderStatus(OrderDTO orderDTO)
    {
        Order order = new Order();

        order.setOrderId(orderDTO.getOrderId());
        order.setStatus(orderDTO.getStatus());

        orderRepo.save(order);

        return "order status updated to " + order.getStatus();
    }

//    @Override
//    public String addProdToOrder(int orderId, int productId)
//    {
//        orderRepo.addProdtoOrder(orderId, productId);
//        return "Product Added To Current Order";
//    }

    @Override
    public Order createOrder(OrderDTO orderDTO)
    {
        Order order = new Order();

        order.setOrderId(orderDTO.getOrderId());
        order.setStatus(orderDTO.getStatus());
        order.setUser(orderDTO.getUser());

        orderRepo.save(order);

        return order;
    }

    @Override
    public String deleteProdFromOrder(int orderId, int prodId)
    {
        orderRepo.delProdFromOrder(orderId, prodId);
        return "Item Removed From Cart";
    }
}
