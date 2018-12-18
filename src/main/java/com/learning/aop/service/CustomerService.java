package com.learning.aop.service;

import com.learning.aop.model.Customers;
import java.util.List;


public interface CustomerService {

	public Customers getClient(int id);
        
        public List<Customers> getAllCustomer();
        public void addCustomer(Customers customer);
}
