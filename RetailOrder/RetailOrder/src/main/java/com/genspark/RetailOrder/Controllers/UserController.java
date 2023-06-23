package com.genspark.RetailOrder.Controllers;

import com.genspark.RetailOrder.DTOs.UserDTO;
import com.genspark.RetailOrder.Entities.User;
import com.genspark.RetailOrder.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/userlist")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteuser/{userId}/{roleId}")
    public String deleteUser(@PathVariable("userId") int userId, @PathVariable("roleId") int roleId) {
        userService.deleteByUserId(userId, roleId);
        return userService.deleteByUserId(userId);
    }

    @PostMapping(path="/save")
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);

        return id;
    }
}
