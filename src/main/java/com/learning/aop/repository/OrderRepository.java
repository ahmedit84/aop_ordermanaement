package com.learning.aop.repository;
import com.learning.aop.model.Order;
import java.util.List;


public interface OrderRepository {
	public Order getOrder(int id);
        
        public List<Order> allOrder();
        
        public void saveOrder(Order order);
}
