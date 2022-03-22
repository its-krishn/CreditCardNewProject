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
import com.training.project.model.CreditCardRegistrationModel;
import com.training.project.repository.CreditCardModelRepo;
import com.training.project.repository.CreditCardRegRepository;
import com.training.project.service.CreditCardService;

@RunWith(MockitoJUnitRunner.class)

public class CreditCardControllerTest {
	
	@InjectMocks
	private CreditCardController controller;
	@Mock
	private CreditCardService service;
	@Mock
	private CreditCardRegRepository userRepository;
	@Mock
	private CreditCardModelRepo creditCardRepository;



	@Test
	public void testRegister()
	{
	CreditCardRegistrationModel user=new CreditCardRegistrationModel ();
	user.setUsername("krishna");
	user.setAccountnumber(785165); 
	user.setAge(22);
	user.setPhonenumber(4585);
	user.setSalary(70000);
	CreditCardModel cardModel=new CreditCardModel();
	cardModel.setUsername("gayu");
	Mockito.when(service.createCreditCard(Mockito.any())).thenReturn(cardModel);
	CreditCardModel creditCard =controller.regiser(user);
	Assert.assertEquals(creditCard.getUsername(), user.getUsername());
	}

	@Test
	public void testUnBlockCard(){

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



	@Test
	public void testBlockCard(){


	CreditCardModel card=new CreditCardModel();
	card.setUsername("krishna");
	card.setCreditCardNumber(9578);
	card.setPassword("krishn@15");
	card.setStatus("unblock");
	card.setCreditLimit(50000);
	Optional<CreditCardModel> optionCard=Optional.of(card);
	Mockito.when(service.block(Mockito.anyInt())).thenReturn(card.getStatus());
	String cardStatus =controller.blockCard(card.getCreditCardNumber());
	Assert.assertEquals(cardStatus, "unblock");
	}



	@Test
	public void TestcardLimitUpdate(){


	CreditCardModel card=new CreditCardModel();
	card.setUsername("krishna");
	card.setCreditCardNumber(9578);
	card.setPassword("krishn@15");
	card.setStatus("unblock");
	card.setCreditLimit(50000);
	Optional<CreditCardModel> optionCard=Optional.of(card);
	Mockito.when(service.cardLimitUpdate(Mockito.anyInt())).thenReturn(card);
	CreditCardModel creditCard =controller.cardLimitUpdate(card.getCreditCardNumber());
	Assert.assertEquals(creditCard.getCreditLimit(), 30000);
	}
	@Test
	public void testAcceptDues(){


	CreditCardModel card=new CreditCardModel();
	card.setUsername("krishna");
	card.setCreditCardNumber(9578);
	card.setPassword("krishna@15");
	card.setStatus("unblock");
	card.setCreditLimit(50000);
	int amount=2000;
	Optional<CreditCardModel> optionCard=Optional.of(card);
	Mockito.when(service.acceptingDue(Mockito.anyInt(), Mockito.anyInt())).thenReturn(card);
	CreditCardModel creditCard =controller.acceptDues(card.getCreditCardNumber(), amount);
	Assert.assertEquals(creditCard.getCreditLimit(), 30000);
	}
	@Test
	public void testCancelCard(){

	CreditCardModel card=new CreditCardModel();
	card.setUsername("krishna");
	card.setCreditCardNumber(9578);
	card.setPassword("krishna@15");
	card.setStatus("cancel");
	card.setCreditLimit(50000);
			
	Optional<CreditCardModel> optionCard=Optional.of(card);
	Mockito.when(service.cancelCreditCard(Mockito.anyInt())).thenReturn(card.getStatus());
	String cardStatus =controller.cancelCreditCard(card.getCreditCardNumber());
	Assert.assertEquals(cardStatus, "cancel");
	}

}
