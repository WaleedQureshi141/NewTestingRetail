package com.genspark.RetailOrder.Services;

import com.genspark.RetailOrder.DTOs.ProdDTO;
import com.genspark.RetailOrder.Entities.Department;
import com.genspark.RetailOrder.Entities.Product;

import java.util.List;

public interface ProdService
{
    List<Product> getAllProducts();
    List<Product> getProdsInDept(int deptId);
    Product addProd(ProdDTO prodDTO);
    List<Product> getProdByName(ProdDTO prodDTO);
    String deleteProd(int prodId);
}
