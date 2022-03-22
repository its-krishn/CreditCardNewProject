/**
 * Spring Boot CreditCardProject 
 * Class Name : CreditCardService
 * Class Description :CreditCardService class for CreditCardProject Application
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
package com.training.project.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.training.project.model.CreditCardHistory;
import com.training.project.model.CreditCardModel;
import com.training.project.model.CreditCardRegistrationModel;
import com.training.project.repository.CreditCardModelRepo;
import com.training.project.repository.CreditCardHistoRepo;
import com.training.project.repository.CreditCardRegRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.Base64;
import java.util.Optional;

@Service
@Slf4j
public class CreditCardService {

	
	@Autowired
	CreditCardHistoRepo creditCardHistoRepo;
	@Autowired
	CreditCardHistory creditCardHistory;
	
	@Autowired
	CreditCardModelRepo creditCardModelRepo;
	@Autowired
	CreditCardRegRepository creditCardRegRepository;

	/**
	 * Method to createCreditCard
	 * 
	 * @param registrationModel
	 * @return creditCardModel
	 */
	public CreditCardModel createCreditCard(CreditCardRegistrationModel registrationModel) {
		log.debug("createCreditCard method started");
		//Base64.Encoder encoder = Base64.getEncoder();
		CreditCardModel creditCard = new CreditCardModel();
		creditCard.setUsername(registrationModel.getUsername());
		creditCard.setCreditCardNumber(registrationModel.getAccountnumber() + 10);
		//creditCard.setPassword(encoder.encodeToString((registrationModel.getUsername().substring(0, 3).concat("123")).getBytes()));
		 
		creditCard.setPassword("123");
		creditCard.setStatus("unblock");
		creditCard.setCreditLimit(50000);
		creditCardModelRepo.save(creditCard);
		log.debug("createCreditCard method end");
		return creditCard;
	}

	/**
	 * Method to unLockCard
	 * 
	 * @param creditCardNumber
	 * @return creditCardModel
	 */
	public String unLockCard(int creditCardNumber) {
		log.info("unLockCard method started with argument creditCardNumber{} ");
	
		String creditCardStatus="null";
		if(!ObjectUtils.isEmpty(creditCardModelRepo.findById(creditCardNumber))){
			Optional<CreditCardModel> card=creditCardModelRepo.findById(creditCardNumber);
			CreditCardModel creditCardModel=card.get();
			creditCardModel.setStatus("unblock");
			creditCardModelRepo.save(creditCardModel); 

			creditCardStatus="unblock";
			}
			else
			{
				creditCardStatus="fruad user ";
			}
		log.debug("unLockCard method end with argument creditCardNumber{} ");
			return creditCardStatus;
			}
		
	/**
	 * Method to blockCard
	 * 
	 * @param creditCardNumber
	 * @return creditCardModel
	 */
	public String block(int creditCardNumber) {
		log.info("blockCard method started with argument creditCardNumber{} ");
	
		String creditCardStatus="null";
		if(!ObjectUtils.isEmpty(creditCardModelRepo.findById(creditCardNumber))){
			Optional<CreditCardModel> card=creditCardModelRepo.findById(creditCardNumber);
			CreditCardModel creditCardModel=card.get();
			creditCardModel.setStatus("block");
			creditCardModelRepo.save(creditCardModel); 

			creditCardStatus="block";
			}
			else
			{
				creditCardStatus="fruad user ";
			}
		log.debug("blockCard method end with argument creditCardNumber{} ");
			return creditCardStatus;
			}
		

	/**
	 * Method to updateCardLimit
	 * 
	 * @param creditCardNumber
	 * @return creditCardModel
	 */
	public CreditCardModel cardLimitUpdate(int creditCardNumber)

	{
		log.info("cardLimitUpdate method started with argument creditCardNumber{} ");
		Optional<CreditCardModel> customer = creditCardModelRepo.findById(creditCardNumber);
		CreditCardModel creditCard = customer.get();
		creditCard.setCreditLimit(creditCard.getCreditLimit() +5000);
		creditCardModelRepo.save(creditCard);
		log.debug("cardLimitUpdate method end with argument creditCardNumber{} ");
		return creditCard;
	}

	/**
	 * Method for acceptingDues
	 * 
	 * @param creditCardNumber
	 * @param amount
	 * @return creditCardModel
	 */
	public CreditCardModel acceptingDue(int creditCardNumber, Integer amount) {
		log.info("acceptingDue method started with argument creditCardNumber{} and amount{} ");

		Optional<CreditCardModel> customer = creditCardModelRepo.findById(creditCardNumber);
		CreditCardModel creditCard = customer.get();
		creditCard.setCreditLimit(creditCard.getCreditLimit() + amount);
		creditCardModelRepo.save(creditCard);
		log.debug("acceptingDue method end with argument creditCardNumber{} and amount{} ");
		return creditCard;
	}

	/**
	 * Method for cancelCreditCard
	 * 
	 * @param creditCardNumber
	 */
	public String cancelCreditCard(int creditCardNumber) {
		log.info("cancelCreditCard method started with argument creditCardNumber{} ");
		LocalDate date = LocalDate.now();
		String status="null";
		Optional<CreditCardModel> customer = creditCardModelRepo.findById(creditCardNumber);
		creditCardHistory.setUsername(customer.get().getUsername());
		creditCardHistory.setCreditCardNumber(creditCardNumber);
		creditCardHistory.setCancelDate(date);
		creditCardHistory.setStatus("cancel");
		status="cancel";
		creditCardHistoRepo.save(creditCardHistory);
		creditCardModelRepo.deleteById(creditCardNumber);
		log.debug("cancelCreditCard method end with argument creditCardNumber{} ");
		return status;
	}

}
