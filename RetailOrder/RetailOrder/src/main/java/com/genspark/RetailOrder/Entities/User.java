package com.genspark.RetailOrder.Entities;

import lombok.*;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User
{
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_fname")
    private String fname;

    @Column(name = "user_lname")
    private String lname;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_address")
    private String address;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id_fk", referencedColumnName = "role_id"))
//    private List<Role> role = new ArrayList<>();

    @Column(name = "role")
    private String role;

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
