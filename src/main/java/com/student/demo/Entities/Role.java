package com.student.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String roleName;

@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name= "user_role",
        joinColumns = @JoinColumn(name="role_id"),
        inverseJoinColumns = @JoinColumn(name="user_id"))

@JsonIgnore
    private Collection<User> users = new ArrayList<>();

}
