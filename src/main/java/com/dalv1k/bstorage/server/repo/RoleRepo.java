package com.dalv1k.bstorage.server.repo;


import com.dalv1k.bstorage.server.entity.ERole;
import com.dalv1k.bstorage.server.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(ERole name);
}