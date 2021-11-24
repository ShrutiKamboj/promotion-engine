package com.engine.promote.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.engine.promote.entity.Promotions;
import com.engine.promote.repository.PromotionRepository;
import com.engine.promote.repository.SKURepository;

@SpringBootTest
class PEngineServiceTest {
	
	@MockBean
	private PromotionRepository pRepo;
	
	@MockBean
	private SKURepository skRepo;
	
	@InjectMocks
	private PEngineService service;

	@Test
	void testGetAmount() {
		Promotions value = new Promotions();
		value.setItem("A");
		value.setActive(true);
		value.setPromotion("PROMO_A");
		value.setPPrice(130);
		value.setLimit(3);
		
		Optional<Promotions> promos = Optional.empty();
		Optional<Promotions> promosA = Optional.of(value);
		
		when(pRepo.findById("a")).thenReturn(promos);
		when(pRepo.findById("A")).thenReturn(promosA);
	}

}
