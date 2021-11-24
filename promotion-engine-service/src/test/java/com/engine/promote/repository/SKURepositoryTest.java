package com.engine.promote.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.engine.promote.entity.UnitPrice;

@SpringBootTest
class SKURepositoryTest {

	@MockBean
	SKURepository skRepo;
	
	UnitPrice unit;
	
	@Test
	void injectedComponentsAreNotNull() {
		assertNotNull(skRepo);
	}
	
	@BeforeEach
	void setUp() {
		unit = new UnitPrice();
		unit.setItem("A");
		unit.setPrice(50);
	}
	
	@Test
	void testFindById() {
		skRepo.save(unit);
		
		Optional<UnitPrice> unitA = Optional.of(unit);
		when(skRepo.findById("A")).thenReturn(unitA);
	}

}
