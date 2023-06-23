package com.genspark.RetailOrder.Repostitories;

import com.genspark.RetailOrder.Entities.Order;
import com.genspark.RetailOrder.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order, Integer>
{
    @Query(value = "SELECT * FROM orders WHERE user_id_fk = :userId", nativeQuery = true)
    List<Order> findOrdersByUserId(@Param("userId") int userId);

    @Query(value = "insert into order_prod(order_id, prod_id) values(?1,?2)", nativeQuery = true)
    @Modifying
    void addProdtoOrder(int orderId, int prodId);

    @Transactional
    @Query(value = "DELETE FROM order_prod op WHERE op.order_id = ?1 AND op.prod_id = ?2", nativeQuery = true)
    @Modifying
    void delProdFromOrder(int orderId, int prodId);

    @Query(value = "SELECT prod_id FROM order_prod WHERE order_id = :orderId", nativeQuery = true)
    List<Integer> getProdsRelOrder(@Param("orderId") int orderId);

    @Query(value = "SELECT * FROM product WHERE prod_id = :prodId", nativeQuery = true)
    List<Product> getProdsInOrder(@Param("prodId") List<Integer> prodId);
}
