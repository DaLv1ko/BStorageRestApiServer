package com.dalv1k.bstorage.server.repo;

import com.dalv1k.bstorage.server.entity.Income;
import com.dalv1k.bstorage.server.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IncomeRepo extends JpaRepository<Income, Integer> {

    List<Income> findAllByModelOrderByDate(Model model);

}
