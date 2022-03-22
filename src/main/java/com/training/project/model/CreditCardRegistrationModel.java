/**
 * Spring Boot CreditCardProject
 * Class Name : CreditCardRegistrationModel
 * Class Description :CreditCardRegistrationModel  class for CreditCardProject Application
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

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Component
@Entity
@Getter
@Setter
@ToString
public class CreditCardRegistrationModel {

	private String username;
	@Id
	private int accountnumber;
	private int phonenumber;
	private int age;
	private int salary;

   

}
