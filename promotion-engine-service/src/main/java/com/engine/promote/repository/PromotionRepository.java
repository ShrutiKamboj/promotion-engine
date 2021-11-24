package com.engine.promote.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.engine.promote.entity.Promotions;

@Repository
public interface PromotionRepository extends CrudRepository<Promotions, String>{

	
}
