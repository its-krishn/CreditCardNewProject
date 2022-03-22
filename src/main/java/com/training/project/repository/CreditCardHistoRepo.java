/**
 * Spring Boot CreditCardProject
 * interface Name :CreditCardHistoRepo 
 * Class Description : CreditCardHistoRepo interface for CreditCardProject Application
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
package com.training.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.model.CreditCardHistory;

public interface CreditCardHistoRepo extends JpaRepository<CreditCardHistory, Integer> {

}
