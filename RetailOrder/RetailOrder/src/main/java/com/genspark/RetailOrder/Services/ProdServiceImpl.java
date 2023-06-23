package com.genspark.RetailOrder.Services;

import com.genspark.RetailOrder.DTOs.DeptDTO;
import com.genspark.RetailOrder.DTOs.ProdDTO;
import com.genspark.RetailOrder.Entities.Department;
import com.genspark.RetailOrder.Entities.Product;
import com.genspark.RetailOrder.Repostitories.DepartmentRepo;
import com.genspark.RetailOrder.Repostitories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdServiceImpl implements ProdService{

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProdsInDept(int deptId) {
        return productRepo.findProdByDept(deptId);
    }

//    @Override
//    public List<Product> getProdsInDept(Department department) {
//        return productRepo.findProdByDept(department);
//    }

    @Override
    public Product addProd(ProdDTO prodDTO)
    {
        Product prod = new Product();

        prod.setProdId(prodDTO.getProdId());
        prod.setProdName(prodDTO.getProdName());
        prod.setPrice(prodDTO.getPrice());
        prod.setProdDesc(prodDTO.getProdDesc());
        prod.setVendor(prodDTO.getVendor());

        Department department = departmentRepo.findById(prodDTO.getDept().getDeptId()).orElse(null);
        prod.setDepartment(prodDTO.getDept());

        productRepo.save(prod);

        return prod;
    }

    @Override
    public List<Product> getProdByName(ProdDTO prodDTO) {
        return productRepo.findByProdName(prodDTO.getProdName());
    }

    @Override
    public String deleteProd(int prodId)
    {
        productRepo.deleteById(prodId);
        return "Product Removed From Database";
    }
}
