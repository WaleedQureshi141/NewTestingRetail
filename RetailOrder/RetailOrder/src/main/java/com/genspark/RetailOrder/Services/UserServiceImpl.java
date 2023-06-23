package com.genspark.RetailOrder.Services;

import com.genspark.RetailOrder.DTOs.LoginDTO;
import com.genspark.RetailOrder.DTOs.UserDTO;
import com.genspark.RetailOrder.Entities.User;
import com.genspark.RetailOrder.Repostitories.UserRepo;
import com.genspark.RetailOrder.Responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

    @Override
    public String deleteByUserId(int userId, int roleId)
    {
        userRepo.deleteUser(userId, roleId);
        return "User Deleted ";
    }

    @Override
    public String deleteByUserId(int userId) {
        userRepo.deleteById(userId);
        return "user deleted from user table";
    }

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserId(),
                userDTO.getFname(),
                userDTO.getLname(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getPhone(),
                userDTO.getAddress(),
                userDTO.getRole()
        );

        userRepo.save(user);

        return user.getFname();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true, user.get().getRole(), user.get().getUserId(), user.get().getFname()+ " " + user.get().getLname());
                } else {
                    return new LoginResponse("Login Failed", false, "", 0, "");
                }
            } else {
                return new LoginResponse("password Not Match", false, "", 0, "");
            }
        } else {
            return new LoginResponse("Email does not exist", false, "", 0, "");
        }
    }

    @Override
    public User getUserById(int studentId) {
        Optional<User> u = userRepo.findById(studentId);
        User user = null;
        if (u.isPresent()){
            user = u.get();
        } else {
            throw new RuntimeException("User ID " + studentId + " not found");
        }
        return user;
    }

    @Override
    public String deleteUser(int studentId) {
        userRepo.deleteById(studentId);
        return "User deleted";
    }

    @Override
    public User updateUser(UserDTO userDTO)
    {
        User existingUser = userRepo.findByUserId(userDTO.getUserId());

        if (existingUser == null) {
            System.out.println("User does not exist");
            return null;
        }

        existingUser.setFname(userDTO.getFname());
        existingUser.setLname(userDTO.getLname());
        existingUser.setPhone(userDTO.getPhone());
        existingUser.setAddress(userDTO.getAddress());

//        User user = new User(
//                userDTO.getUserId(),
//                userDTO.getFname(),
//                userDTO.getLname(),
//                userDTO.getEmail(),
//                userDTO.getPassword(),
//                userDTO.getPhone(),
//                userDTO.getAddress(),
//                userDTO.getRole()
//        );
        return userRepo.save(existingUser);
    }
}
