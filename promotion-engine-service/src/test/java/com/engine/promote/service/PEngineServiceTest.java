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
		
		Optional<Promotions> promos = Optional.empty();
		when(pRepo.findById("a")).thenReturn(promos);
		//fail("Not yet implemented");
	}

}
