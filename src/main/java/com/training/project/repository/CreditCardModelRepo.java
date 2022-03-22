/**
 * Spring Boot CreditCardProject
 * interface Name : CreditCardModelRepo
 * Class Description : CreditCardModelRepo interface for CreditCardProject Application
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

import com.training.project.model.CreditCardModel;

public interface CreditCardModelRepo extends JpaRepository<CreditCardModel, Integer> {
    
}
