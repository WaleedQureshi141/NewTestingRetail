package com.genspark.RetailOrder.Controllers;

import com.genspark.RetailOrder.DTOs.ProdDTO;
import com.genspark.RetailOrder.Entities.Department;
import com.genspark.RetailOrder.Entities.Product;
import com.genspark.RetailOrder.Services.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prods")
public class ProductController
{
    /*
    GET method to get all products (USER ROLE)
        api/prods/prodlist
    GET method to get all products in a department(USER ROLE)
        api/prods/deptprods
    POST method to add products (ADMIN ROLE) -> OPTIONAL
    PUT method to change any product (ADMIN ROLE) -> OPTIONAL
    DELETE method to delete products (ADMIN)
        api/prods/removeprod
     */

    @Autowired
    private ProdService prodService;

    @GetMapping("/prodlist")
    public List<Product> getAllProds()
    {
        return prodService.getAllProducts();
    }

    @GetMapping("/deptprods/{deptId}")
    public List<Product> getProdsInDept(@PathVariable("deptId") int deptId)
    {
        return prodService.getProdsInDept(deptId);
    }

    @PostMapping("/addprod")
    public Product addProd(@RequestBody ProdDTO product)
    {
        Product product1 = prodService.addProd(product);
        return product1;
    }

    @DeleteMapping
    public String deleteProd(int prodId)
    {
        return deleteProd(prodId);
    }
}
