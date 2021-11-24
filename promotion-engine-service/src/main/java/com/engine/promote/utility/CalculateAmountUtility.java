package com.engine.promote.utility;

import org.springframework.stereotype.Component;

@Component
public class CalculateAmountUtility {

	public double getPriceForN(int quantity, int limit, int unitPrice, double pPrice) {
		double price=0;
		int pQuant = quantity/limit;
		int sQuant = quantity%limit;
		
		price = pQuant*pPrice+sQuant*unitPrice;
		
		return price;
		
	}
	
	public double getPriceForUnitCD(int quantityC, int quantityD, int limit, int unitPriceC, int unitPriceD, double pPrice) {
		double price=0;
		int pQuant = Math.min(quantityC, quantityD);
		price += pQuant*pPrice;
		int cQuant = quantityC-pQuant;
		int dQuant = quantityD-pQuant;
		
		price += cQuant*unitPriceC + dQuant*unitPriceD;
		return price;
		
	}
	
}
