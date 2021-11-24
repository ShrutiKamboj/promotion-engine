package com.engine.promote.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.engine.promote.model.PromotionRequest;
import com.engine.promote.model.PromotionResponse;
import com.engine.promote.model.Unit;
import com.engine.promote.service.PEngineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
class PromotionEngineControllerTest {

	private MockMvc mockMvc;
	
	@Mock
    private PEngineService pEngineService;
    
    @Autowired
    PromotionEngineController pEngineController;
    
    @Autowired
    private WebApplicationContext wac;
    
    @BeforeEach
    public void setUp() {
    	mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
	@Test
	public void testGetAmount() throws Exception {
		List<Unit> cart = new ArrayList<Unit>();
		cart.add(new Unit("A", 30));
		PromotionRequest promoRequest = new PromotionRequest();
		promoRequest.setCart(cart);
        
		PromotionResponse promoResp = new PromotionResponse();
		promoResp.setAmount(new BigDecimal(1300));

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			mockMvc.perform(post("/cart/amount")
			        .contentType(MediaType.APPLICATION_JSON)
			        .content(objectMapper .writeValueAsString(promoRequest)))
			            .andExpect(status().isOk());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		when(pEngineService.getAmount(promoRequest)).thenReturn(promoResp);
		PromotionResponse promoResp2 = pEngineController.getAmount(promoRequest);
		assertThat(promoResp2.getAmount()).isEqualTo(promoResp.getAmount());
		
	}

}
