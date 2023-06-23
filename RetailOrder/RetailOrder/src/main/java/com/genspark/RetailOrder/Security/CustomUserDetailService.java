package com.genspark.RetailOrder.Security;

import com.genspark.RetailOrder.Entities.Role;
import com.genspark.RetailOrder.Entities.User;
import com.genspark.RetailOrder.Repostitories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomUserDetailService //implements UserDetailsService
{
//    private UserRepo userRepo;
//
//    @Autowired
//    public CustomUserDetailService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//    {
//        User user = userRepo.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                mapRoleToAuthorities(user.getRole())
//        );
//    }
//
//    private Collection<GrantedAuthority> mapRoleToAuthorities(List<Role> roles)
//    {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
//    }
}
