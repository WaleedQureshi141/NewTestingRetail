package com.genspark.RetailOrder.Repostitories;

import com.genspark.RetailOrder.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
