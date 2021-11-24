package com.engine.promote.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.engine.promote.model.PromotionRequest;
import com.engine.promote.model.PromotionResponse;
import com.engine.promote.service.PEngineService;

@RestController
public class PromotionEngineController {

	@Autowired
	PEngineService service;
	@RequestMapping(method = RequestMethod.POST, value = "/cart/amount")
	public PromotionResponse getAmount(@RequestBody PromotionRequest request) throws Exception {
		PromotionResponse response ;
		try {
			response = service.getAmount(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Cart is Empty");
		}
		return response;
	}
}
