package com.learning.aop.controller;

import com.learning.aop.model.Order;
import com.learning.aop.service.CustomerService;
import com.learning.aop.service.OrderService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
        @Autowired
        private CustomerService customerService;
        
       static Random rand = new Random(); 
       
        @RequestMapping("/allOrders")
	public ModelAndView allOrders(){  
            ModelAndView mv=new ModelAndView("showOrder");
            mv.addObject("order",new Order());
            mv.addObject("customers", customerService.getAllCustomer());
            mv.addObject("orders", orderService.allOrder());
           
            return mv;
        }

	@RequestMapping("/getOrders")
	public String getOrders(Model model, @RequestParam("id") int id) {
		Order order = orderService.getOrder(id);
		model.addAttribute("order", order);
		
		return "showOrder";
	}
        
        @RequestMapping(path = "/addOrder",method = RequestMethod.POST)
        public String addOrder(@ModelAttribute("order")Order order){
            order.setOrderId(rand.nextInt());
            orderService.saveOrder(order);
            
            return "redirect:allOrders";
        }
        
        
}
