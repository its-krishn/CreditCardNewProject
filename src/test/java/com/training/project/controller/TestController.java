package com.training.project.controller;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.training.project.model.CreditCardModel;
import com.training.project.repository.CreditCardModelRepo;
import com.training.project.repository.CreditCardRegRepository;
import com.training.project.service.CreditCardService;

@RunWith(MockitoJUnitRunner.class)
public class TestController {
	@InjectMocks
	private CreditCardController controller;
	@Mock
	private CreditCardService service;
	@Mock
	private CreditCardRegRepository userRepository;
	@Mock
	private CreditCardModelRepo creditCardRepository;


	@Test
	public void testUnBlockCard() {

	CreditCardModel card=new CreditCardModel();
	card.setUsername("krishna");
	card.setCreditCardNumber(9578);
	card.setPassword("krishn@15");
	card.setStatus("block");
	card.setCreditLimit(50000);
	Optional<CreditCardModel> optionCard=Optional.of(card);
	Mockito.when(service.unLockCard(Mockito.anyInt())).thenReturn(card.getStatus());
	String cardStatus =controller.unBlockCard(card.getCreditCardNumber());
	Assert.assertEquals(cardStatus, "block");
	}

}
