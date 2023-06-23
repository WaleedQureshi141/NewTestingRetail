package com.genspark.RetailOrder.Controllers;

import com.genspark.RetailOrder.DTOs.LoginDTO;
import com.genspark.RetailOrder.DTOs.RegisterDTO;
import com.genspark.RetailOrder.DTOs.UserDTO;
import com.genspark.RetailOrder.Entities.Role;
import com.genspark.RetailOrder.Entities.User;
import com.genspark.RetailOrder.Repostitories.RoleRepo;
import com.genspark.RetailOrder.Repostitories.UserRepo;
import com.genspark.RetailOrder.Responses.LoginResponse;
import com.genspark.RetailOrder.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("api/auth")
public class LoginController
{
//    private UserService userService;
//    private AuthenticationManager authenticationManager;
//    private UserRepo userRepo;
//    private RoleRepo roleRepo;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public LoginController(UserService userService, AuthenticationManager authenticationManager, UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.authenticationManager = authenticationManager;
//        this.userRepo = userRepo;
//        this.roleRepo = roleRepo;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @GetMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO)
//    {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                loginDTO.getEmail(),
//                loginDTO.getPassword()
//        ));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<>("user signed in success", HttpStatus.OK);
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody UserDTO userDTO)
//    {
//        if (userRepo.existsByEmail(userDTO.getEmail()))
//        {
//            return new ResponseEntity<>("Email Already Exists", HttpStatus.BAD_REQUEST);
//        }
//
//        User user = new User();
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//
//        Role role = roleRepo.findByRoleName("USER").get();
//        user.setRole(Collections.singletonList(role));
//
//        userRepo.save(user);
//
//        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
//    }
//
//    @PutMapping("/adduserinfo")
//    public User addInfo(@RequestBody UserDTO userDTO)
//    {
////        User userCheck = userService.findByUserId(userDTO.getUserId());
//
////        System.out.println(userCheck.toString());
////        System.out.println(userDTO.toString());
////
////        if (userCheck == null)
////        {
////            System.out.println("user does not exist");
////            return null;
////        }
//
//        return userService.updateUser(userDTO);
//    }
//
//    // to add admin role user
//    @PostMapping("/registeradmin")
//    public ResponseEntity<String> registeradmin(@RequestBody UserDTO userDTO)
//    {
//        if (userRepo.existsByEmail(userDTO.getEmail()))
//        {
//            return new ResponseEntity<>("Email Already Exists", HttpStatus.BAD_REQUEST);
//        }
//
//        User user = new User();
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//
//        Role role = roleRepo.findByRoleName("ADMIN").get();
//        user.setRole(Collections.singletonList(role));
//
//        userRepo.save(user);
//
//        return new ResponseEntity<>("Admin Registered Successfully", HttpStatus.OK);
//    }
//
//    @PutMapping("/addadmininfo")
//    public User addadminInfo(@RequestBody UserDTO userDTO)
//    {
////        if (!userRepo.existsById(userDTO.getUserId()))
////        {
////            System.out.println("user does not exist");
////            return null;
////        }
//
//        return userService.updateUser(userDTO);
//    }

    @Autowired
    private UserService userService;
    @PostMapping(path="/log")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
