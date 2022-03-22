/**
 * Spring Boot CreditCardProject
 * Class Name : CreditCardController
 * Class Description : Controller class for CreditCardProject Application
 * @author :vn51ore   
 * @version jdk : 1.8
 * 
 * Copyright Notice
 * 
 * Copyright (c) 2021 Walmart. All Right Reserved.
 * This software is the confidential and proprietary information of WalMart
 * You shall not disclose or use Confidential information without the express
 * written agreement of Walmart
 *
 **/
package com.training.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.registration.FormController;
import com.training.project.model.CreditCardModel;
import com.training.project.model.CreditCardRegistrationModel;
import com.training.project.repository.CreditCardHistoRepo;
import com.training.project.repository.CreditCardModelRepo;
import com.training.project.repository.CreditCardRegRepository;
import com.training.project.service.CreditCardService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CreditCardController {
	@Autowired
	CreditCardHistoRepo creditCardHistoRepo;
	@Autowired
	CreditCardService service;
	@Autowired
	CreditCardModelRepo creditCardModelRepo;
	@Autowired
	CreditCardRegRepository creditCardRegRepository;

	/**
	 * Method to get Regestration form
	 * 
	 * @return UserRegistration
	 */
	@RequestMapping("/")
	public String UserRegistration() {
		log.debug("UserRegistration method started");
		return "UserRegistration";
	}

	/**
	 * Method to createCreditCard
	 * 
	 * @param registrationModel
	 * @return UserRegistration
	 */
	@RequestMapping("/regform")
	public String registration(CreditCardRegistrationModel registrationModel) {
		log.debug("registration method started");
		CreditCardModel card = service.createCreditCard(registrationModel);
		creditCardRegRepository.save(registrationModel);
		log.debug("registration method end");
		return "UserRegistration";
	}
	
	@PostMapping("/regform")
	public CreditCardModel regiser(CreditCardRegistrationModel registrationModel) {
		log.debug("registration method started");
		CreditCardModel card = service.createCreditCard(registrationModel);
		creditCardRegRepository.save(registrationModel);
		log.debug("registration method end");
		return card;
	}

	/**
	 * Method to unLock CreditCard
	 * 
	 * @param cardNo
	 * @return card
	 */
	@PutMapping("/unLockCard/{creditCardNumber}")
	public String unBlockCard(@PathVariable("creditCardNumber") int cardNo) {
		log.info("unBlockCard method started with argument cardNo{}", cardNo);
		String card = service.unLockCard(cardNo);
		log.debug("unBlockCard method end with argument cardNo{}", cardNo);
		return card;
	}

	/**
	 * Method to Block CreditCard
	 * 
	 * @param cardNo
	 * @return card
	 */
	@PutMapping("/blockCard/{creditCardNumber}")
	public String blockCard(@PathVariable("creditCardNumber") int cardNo) {
		log.info("blockCard method started with argument cardNo{}", cardNo);
		String card = service.block(cardNo);
		log.debug("blockCard method end with argument cardNo{}", cardNo);
		return card;
	}

	/**
	 * Method to update cardLimit
	 * 
	 * @param cardNo
	 * @return card
	 */

	@PutMapping("/cardLimitUpdate/{creditCardNumber}")
	public CreditCardModel cardLimitUpdate(@PathVariable("creditCardNumber") int cardNo) {
		log.info("cardLimitUpdate method started with argument cardNo{}", cardNo);
		CreditCardModel card = service.cardLimitUpdate(cardNo);
		log.debug("cardLimitUpdate method end with argument cardNo{}", cardNo);
		return card;
	}

	/**
	 * Method to accept credit card dues
	 * 
	 * @param cardNo
	 * @param amount
	 * @return card
	 */

	@PutMapping("/acceptingDue/{cardNo}/{amount}")
	public CreditCardModel acceptDues(@PathVariable int cardNo, @PathVariable Integer amount) {
		log.info("acceptingDue method started with argument cardNo{} ,amount{} ", cardNo, amount);
		CreditCardModel card = service.acceptingDue(cardNo, amount);
		log.debug("acceptingDue method end with argument cardNo{} ,amount{} ", cardNo, amount);
		return card;
	}

	/**
	 * Method to cancel creditCard
	 * 
	 * @param cardNo
	 */

	@DeleteMapping("/cancelCreditCard/{creditCardNumber}")
	public String cancelCreditCard(@PathVariable("creditCardNumber") int cardNo) {
		
		log.info("cancelCreditCard method started with argument cardNo{}", cardNo);
		String card=service.cancelCreditCard(cardNo);
		log.debug("cancelCreditCard method end with argument cardNo{}", cardNo);
        return card;
	}

}
