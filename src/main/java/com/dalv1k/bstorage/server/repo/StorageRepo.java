package com.dalv1k.bstorage.server.repo;

import com.dalv1k.bstorage.server.entity.Model;
import com.dalv1k.bstorage.server.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StorageRepo extends JpaRepository<Storage, Integer> {

    List<Storage> findAllByAmountGreaterThan(Integer amount);

    Storage findByModel(Model model);
}
