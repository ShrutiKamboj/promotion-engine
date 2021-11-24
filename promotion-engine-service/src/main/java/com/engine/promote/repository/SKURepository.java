package com.engine.promote.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.engine.promote.entity.UnitPrice;

@Repository
public interface SKURepository extends CrudRepository<UnitPrice, String>{

}
