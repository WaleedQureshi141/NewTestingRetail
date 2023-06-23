package com.genspark.RetailOrder.Repostitories;

import com.genspark.RetailOrder.DTOs.UserDTO;
import com.genspark.RetailOrder.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer>
{
    @Query(value = "SELECT * FROM user WHERE user_id = :userId", nativeQuery = true)
    User findByUserId(@Param("userId") int userId);

//    @Query(value = "SELECT (user_email, user_password) FROM user WHERE user_email = :email", nativeQuery = true)
//    Optional<User> findByEmail(@Param("email") String email);
    boolean existsByEmail(String email);

    @Query(value = "DELETE FROM user_role uc WHERE uc.user_id_fk = ?1 and uc.role_id_fk =?2", nativeQuery = true)
    @Modifying
    void deleteUser(int userId, int roleId);

    Optional<User> findOneByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
