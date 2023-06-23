package com.genspark.RetailOrder.Controllers;

import com.genspark.RetailOrder.DTOs.OrderDTO;
import com.genspark.RetailOrder.Entities.Order;
import com.genspark.RetailOrder.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    /*
    GET method to get all orders for a user (USER ROLE)
        api/order/history
    GET method to get all orders (ADMIN ROLE) -> OPTIONAL
    POST method to add products to an Order (USER ROLE)
        api/order/addprod
    PUT method to either refund or update an existing order (USER ROLE)
        api/order/editprod
     */

    @GetMapping("/history/{userId}")
    public List<Order> getOrderForUser(@PathVariable int userId)
    {
        return orderService.getOrderByUserId(userId);
    }

    @PostMapping("/createorder")
    public Order createOrder(@RequestBody OrderDTO orderDTO)
    {
        return orderService.createOrder(orderDTO);
    }

    @PutMapping("/addprodtoorder")
    public String addProdToOrder(@RequestBody OrderDTO orderDTO)
    {
        return orderService.addProdToOrder(orderDTO);
    }

    @PutMapping("/editorderstatus")
    public String changeStatus(@RequestBody OrderDTO orderDTO)
    {
        return orderService.addProdToOrder(orderDTO);
    }

    @DeleteMapping("removeprodfromorder/{orderId}/{prodId}")
    public String removeProdFromOrder(@PathVariable("orderId") int orderId, @PathVariable("prodId") int prodId)
    {
        return orderService.deleteProdFromOrder(orderId, prodId);
    }
}
