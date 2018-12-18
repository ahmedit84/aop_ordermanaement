package com.learning.aop.repository;
import com.learning.aop.model.Customers;
import java.util.List;


public interface CustomerRepository {
	public Customers getClient(int id);
        public List<Customers> getAllCustomer();
        public void addCustomer(Customers customer);
}
