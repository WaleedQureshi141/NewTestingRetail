package com.genspark.RetailOrder.Repostitories;

import com.genspark.RetailOrder.Entities.Department;
import com.genspark.RetailOrder.Entities.Product;
import com.genspark.RetailOrder.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product, Integer>
{
    @Query(value = "SELECT * FROM product WHERE dept_id_fk = :deptId", nativeQuery = true)
    List<Product> findProdByDept(@Param("deptId") int deptId);

    @Query(value = "SELECT * FROM product WHERE prod_name = :prodName", nativeQuery = true)
    List<Product> findByProdName(@Param("prodName") String prodName);
}
