package com.engine.promote.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculateAmountUtilityTest {

	@Autowired
	CalculateAmountUtility util;
	
	@Test
	void testGetPriceForN() {
		int quant = 5;
		int limit = 3;
		int qPrice = 50;
		int pPrice = 130;
		
		assertEquals(util.getPriceForN(quant, limit, qPrice, pPrice), 230);
	}

	@Test
	void testGetPriceForUnitCD() {
		int cQuant = 2;
		int dQuant = 3;
		int limit=1;
		int unitPriceC=20;
		int unitPriceD = 15;
		int pPrice=30;
		
		assertEquals(util.getPriceForUnitCD(cQuant, dQuant, limit, unitPriceC, unitPriceD, pPrice), 75);
	}

}
