package com.dalv1k.bstorage.server.repo;

import com.dalv1k.bstorage.server.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Integer> {
}
