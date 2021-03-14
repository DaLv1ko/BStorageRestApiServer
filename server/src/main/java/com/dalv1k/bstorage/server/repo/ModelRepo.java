package com.dalv1k.bstorage.server.repo;

import com.dalv1k.bstorage.server.entity.Brand;
import com.dalv1k.bstorage.server.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepo extends JpaRepository<Model,Integer> {

     Model findByModel (String model);
}
