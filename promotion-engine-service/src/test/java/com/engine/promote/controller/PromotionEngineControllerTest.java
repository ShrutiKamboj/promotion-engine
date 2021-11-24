package com.engine.promote.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.engine.promote.model.PromotionRequest;
import com.engine.promote.model.PromotionResponse;
import com.engine.promote.model.Unit;
import com.engine.promote.service.PEngineService;

class PromotionEngineControllerTest {

	@Autowired
    MockMvc mockMvc;

    @MockBean
    private PEngineService pEngineService;
    
    @InjectMocks
    PromotionEngineController pEngineController;
    
	@Test
	void testGetAmount() {
		List<Unit> cart = new ArrayList<Unit>();
		cart.add(new Unit("A", 30));
		PromotionRequest promoRequest = new PromotionRequest();
		promoRequest.setCart(cart);
        
		PromotionResponse promoResp = new PromotionResponse();
		promoResp.setAmount(new BigDecimal(1300));
		when(pEngineService.getAmount(promoRequest)).thenReturn(promoResp);
		
		PromotionResponse promoResp2 = pEngineController.getAmount(promoRequest);
		assertThat(promoResp2.getAmount()).isEqualTo(promoResp.getAmount());
		
	}

}
