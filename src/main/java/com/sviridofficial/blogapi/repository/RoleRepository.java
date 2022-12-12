package com.sviridofficial.blogapi.repository;

import com.sviridofficial.blogapi.model.role.Role;
import com.sviridofficial.blogapi.model.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName name);
}
