package com.learning.aop.service;

import com.learning.aop.model.Order;
import java.util.List;


public interface OrderService {

	public Order getOrder(int id);
        public List<Order> allOrder();
         public void saveOrder(Order order);
}
