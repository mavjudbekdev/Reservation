package com.example.reservatio.role.repository;

import com.example.reservatio.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>
{
    Role findByName(String name);
}
