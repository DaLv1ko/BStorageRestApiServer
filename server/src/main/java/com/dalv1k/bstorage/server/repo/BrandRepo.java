package com.dalv1k.bstorage.server.repo;

import com.dalv1k.bstorage.server.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Integer> {

     Brand findByBrand (String brand);

}
