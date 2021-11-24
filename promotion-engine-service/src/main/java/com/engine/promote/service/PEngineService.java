package com.engine.promote.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engine.promote.entity.Promotions;
import com.engine.promote.entity.UnitPrice;
import com.engine.promote.model.PromotionRequest;
import com.engine.promote.model.PromotionResponse;
import com.engine.promote.model.Unit;
import com.engine.promote.repository.PromotionRepository;
import com.engine.promote.repository.SKURepository;
import com.engine.promote.utility.CalculateAmountUtility;

@Service
public class PEngineService {

	@Autowired
	public PromotionRepository pRepo;
	
	@Autowired
	public CalculateAmountUtility util;
	
	@Autowired
	public SKURepository skRepo;
	
	public PromotionResponse getAmount(PromotionRequest promoRequest) throws Exception {
		// TODO Auto-generated method stub
		PromotionResponse response = new PromotionResponse();
		Map<String, Integer> items = new HashMap<String, Integer>();
		Set<String> v = new HashSet<String>();
		double p=0;
		
		if (promoRequest.getCart().size() <=0) {
			throw new Exception("Cart is empty");
		}
		
		for (Unit unit: promoRequest.getCart()) {
			items.put(unit.getItem(), unit.getQuantity());
		}
		
		for (String item: items.keySet()) {
			Optional<Promotions> promotions = pRepo.findById(item);
			
			if (promotions.get().isActive()) {
				if (promotions.get().getPromotion().contentEquals("PROMO_A") || promotions.get().getPromotion().contentEquals("PROMO_B")) {
					Optional<UnitPrice> unitPrice = skRepo.findById(item);
					v.add(item);
					p += util.getPriceForN(items.get(item), promotions.get().limit, unitPrice.get().price, promotions.get().pPrice);
				}
				
				if (promotions.get().getPromotion().contentEquals("PROMO_C_D") && !v.contains(item)) {

					Optional<UnitPrice> unitPrice = skRepo.findById("C");
					Optional<UnitPrice> unitPriceD = skRepo.findById("D");
					int cQuant=items.getOrDefault("C", 0);
					int dQuant=items.getOrDefault("D", 0);
					v.add("C");
					v.add("D");
					p += util.getPriceForUnitCD(cQuant, dQuant, promotions.get().limit, unitPrice.get().price, unitPriceD.get().price, promotions.get().pPrice);
				}
			}
		}
		
		response.setAmount(new BigDecimal(p));
		return response;
	}

}
