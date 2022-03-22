/**
 * Spring Boot CreditCardProject
 * interface Name : CreditCardRegRepository
 * Class Description : CreditCardRegRepository interface for CreditCardProject Application
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
import org.springframework.stereotype.Repository;

import com.training.project.model.CreditCardRegistrationModel;
@Repository
public interface CreditCardRegRepository extends JpaRepository<CreditCardRegistrationModel, Integer>  {

}
