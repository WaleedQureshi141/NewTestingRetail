package com.genspark.RetailOrder.Repostitories;

import com.genspark.RetailOrder.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface RoleRepo extends JpaRepository<Role, Integer>
{
    Optional<Role> findByRoleName(String roleName);
}
