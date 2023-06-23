package com.genspark.RetailOrder.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "department")
public class Department
{
    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "dept_desc")
    private String deptDesc;
}
