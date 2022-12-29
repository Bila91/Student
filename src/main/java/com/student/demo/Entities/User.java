package com.student.demo.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    private String username;
    private String email;
    private String password;
    private String adresse;
    private String telephone;


    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)

    private Collection<Role> roles = new ArrayList<>();



}
