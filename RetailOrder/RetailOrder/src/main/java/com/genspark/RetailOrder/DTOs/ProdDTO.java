package com.genspark.RetailOrder.DTOs;

import com.genspark.RetailOrder.Entities.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProdDTO
{
    private int prodId;
    private int price;
    private String prodDesc;
    private String prodName;
    private String vendor;
    private Department dept;
}
