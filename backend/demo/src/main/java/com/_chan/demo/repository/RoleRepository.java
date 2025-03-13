package com._chan.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._chan.demo.model.Role;
import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByAuthority(String authority);
}
