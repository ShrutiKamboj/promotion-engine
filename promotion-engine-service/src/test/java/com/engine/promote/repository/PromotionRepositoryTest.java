package com.engine.promote.repository;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.engine.promote.entity.Promotions;

@SpringBootTest
class PromotionRepositoryTest {

	@MockBean
	PromotionRepository pRepo;
	
	Promotions value = new Promotions();
	
	@BeforeEach
	void setUp() {
		value.setItem("A");
		value.setActive(true);
		value.setPromotion("PROMO_A");
		value.setPPrice(130);
		value.setLimit(3);
	}
	
	@Test
	void injectedComponentsAreNotNull() {
		assertNotNull(pRepo);
	}
	
	@Test
	void testFindById() {
		pRepo.save(value);
		
		Optional<Promotions> promosA = Optional.of(value);
		when(pRepo.findById("A")).thenReturn(promosA);
	}

}
