package com.engine.promote.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.engine.promote.model.PromotionRequest;
import com.engine.promote.model.PromotionResponse;

@RestController
public class PromotionEngineController {

	@RequestMapping(method = RequestMethod.POST, value = "/cart/amount")
	public PromotionResponse getAmount(@RequestBody PromotionRequest request) {
		PromotionResponse response = new PromotionResponse();
		
		return response;
	}
}
