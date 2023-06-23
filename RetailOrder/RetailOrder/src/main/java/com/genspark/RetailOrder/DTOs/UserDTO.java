package com.genspark.RetailOrder.DTOs;

import com.genspark.RetailOrder.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO
{
    private int userId;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String phone;
    private String address;
        private String role;
}
