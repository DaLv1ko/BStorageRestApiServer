package com.dalv1k.bstorage.server.repo;

import com.dalv1k.bstorage.server.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Integer> {

    Supplier findBySupplier(String supplier);
}
