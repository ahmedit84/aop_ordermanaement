package com.learning.aop.service;

import com.learning.aop.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.learning.aop.repository.CustomerRepository;
import java.util.List;


@Service("clientService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository clientRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Customers getClient(int id) {
		return clientRepository.getClient(id);
	}
        
        @Override
	@Transactional(readOnly = true)
        public List<Customers> getAllCustomer(){
            return clientRepository.getAllCustomer();
        }
        
        @Override
        @Transactional
        public void addCustomer(Customers customer){
            clientRepository.addCustomer(customer);
            
        }
}
