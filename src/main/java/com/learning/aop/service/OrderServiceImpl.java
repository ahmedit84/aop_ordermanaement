package com.learning.aop.service;

import com.learning.aop.model.Order;
import com.learning.aop.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Order getOrder(int id) {
		return orderRepository.getOrder(id);
	}
        
        @Override
        @Transactional
        public List<Order> allOrder(){
            return orderRepository.allOrder();
        }
       
        @Override
        @Transactional
         public void saveOrder(Order order){
             orderRepository.saveOrder(order);
         }
}
