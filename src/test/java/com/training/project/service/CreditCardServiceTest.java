package com.training.project.service;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.training.project.model.CreditCardModel;
import com.training.project.model.CreditCardRegistrationModel;
import com.training.project.repository.CreditCardHistoRepo;
import com.training.project.repository.CreditCardModelRepo;
import com.training.project.repository.CreditCardRegRepository;

@RunWith(MockitoJUnitRunner.class)

public class CreditCardServiceTest {

	@InjectMocks
	private CreditCardService creditCardService;

	@Mock
	private CreditCardRegRepository userRepository;

	@Mock
	private CreditCardModelRepo creditCardRepository;
	@Mock
	CreditCardHistoRepo cardHistoryRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateCard() {

		CreditCardRegistrationModel user = new CreditCardRegistrationModel();
		user.setUsername("krishna");
		user.setAccountnumber(785165);
		user.setAge(22);
		user.setPhonenumber(4585);
		user.setSalary(70000);
		CreditCardModel card = creditCardService.createCreditCard(user);
		Assert.assertEquals(card.getUsername(), user.getUsername());
	}

	@Test
	public void testUnblockCard() {

		CreditCardModel card = new CreditCardModel();
		card.setUsername("krishna");
		card.setCreditCardNumber(9578);
		card.setPassword("krishn@15");
		card.setStatus("block");
		card.setCreditLimit(50000);
		Optional<CreditCardModel> optionCard = Optional.of(card);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		String cardStatus = creditCardService.unLockCard(card.getCreditCardNumber());
		Assert.assertEquals(cardStatus, "unblock");

	}

	@Test
	public void testBlockCard() {

		CreditCardModel card = new CreditCardModel();
		card.setUsername("krishna");
		card.setCreditCardNumber(9578);
		card.setPassword("krishn@15");
		card.setStatus("Unblock");
		card.setCreditLimit(50000);
		Optional<CreditCardModel> optionCard = Optional.of(card);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		String cardStatus = creditCardService.block(card.getCreditCardNumber());
		Assert.assertEquals(cardStatus, "block");

	}

	@Test
	public void testcardLimitUpdate() {

		CreditCardModel card = new CreditCardModel();
		card.setUsername("krishna");
		card.setCreditCardNumber(9578);
		card.setPassword("krishn@15");
		card.setStatus("Unblock");
		card.setCreditLimit(50000);
		Optional<CreditCardModel> optionCard = Optional.of(card);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		CreditCardModel creditCardModel = creditCardService.cardLimitUpdate(card.getCreditCardNumber());
		Assert.assertEquals(creditCardModel.getCreditLimit(), 35000);

	}

	@Test
	public void testAcceptDues() {

		CreditCardModel card = new CreditCardModel();
		card.setUsername("krishna");
		card.setCreditCardNumber(9578);
		card.setPassword("krishn@15");
		card.setStatus("Unblock");
		card.setCreditLimit(50000);
		int amount = 2000;
		Optional<CreditCardModel> optionCard = Optional.of(card);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		CreditCardModel creditCardModel = creditCardService.acceptingDue(card.getCreditCardNumber(), amount);
		Assert.assertEquals(creditCardModel.getCreditLimit(), 32000);

	}

	@Test
	public void testCancelCard() {

		CreditCardModel card = new CreditCardModel();
		card.setUsername("krishna");
		card.setCreditCardNumber(9578);
		card.setPassword("krishn@15");
		card.setStatus("Unblock");
		card.setCreditLimit(50000);
		LocalDate date = LocalDate.now();
		Optional<CreditCardModel> optionCard = Optional.of(card);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		String cardStatus = creditCardService.cancelCreditCard(card.getCreditCardNumber());
		Assert.assertEquals(cardStatus, "cancel");

	}

}
