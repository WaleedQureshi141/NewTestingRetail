package com.genspark.RetailOrder.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponse
{
    String message;
    Boolean status;
    String role;
    int id;
    String fullName;
}
