/**
 * Spring Boot CreditCardProject
 * Class Name : CreditCardHistory
 * Class Description : CreditClassHistory class for CreditCardProject Application
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
package com.training.project.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Component
@Getter
@Setter
@ToString
public class CreditCardHistory {
	
	private String username;
	@Id
	private int creditCardNumber;
	private LocalDate cancelDate;
	private String status;
	
	
	
}
	