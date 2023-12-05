package com.example.reservatio.role.entity;

import com.example.reservatio.permissions.entity.Permissions;
import com.example.reservatio.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "role")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<User> users;

    @Enumerated(EnumType.STRING)
    private List<Permissions> permissions;
}
