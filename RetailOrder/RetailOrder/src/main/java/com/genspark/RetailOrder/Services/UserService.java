package com.genspark.RetailOrder.Services;

import com.genspark.RetailOrder.DTOs.LoginDTO;
import com.genspark.RetailOrder.DTOs.UserDTO;
import com.genspark.RetailOrder.Entities.User;
import com.genspark.RetailOrder.Responses.LoginResponse;

import java.util.List;

public interface UserService
{
    List<User> getAllUsers();
    String deleteByUserId(int userId, int roleId);
    String deleteByUserId(int userId);
//    User updateUser(UserDTO userDTO);
    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);

    User getUserById(int studentId);

    String deleteUser(int studentId);

    User updateUser(UserDTO userDTO);
}
