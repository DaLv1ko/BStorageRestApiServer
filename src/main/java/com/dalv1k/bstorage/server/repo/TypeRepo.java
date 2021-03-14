package com.dalv1k.bstorage.server.repo;

import com.dalv1k.bstorage.server.entity.Brand;
import com.dalv1k.bstorage.server.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface TypeRepo extends JpaRepository<Type, Integer> {

     Type findByType (String type);
}
