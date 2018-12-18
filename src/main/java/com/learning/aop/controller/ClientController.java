package com.learning.aop.controller;

import com.learning.aop.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.learning.aop.service.CustomerService;
import java.util.Random;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ClientController {
	@Autowired
	private CustomerService customerService;

        
        static Random rand = new Random(); 
       
        @RequestMapping("/allCustomers")
	public ModelAndView allCustomers(){  
            ModelAndView mv=new ModelAndView("showCustomer");
            mv.addObject("customer",new Customers());
            mv.addObject("customers", customerService.getAllCustomer());
           
            return mv;
        }
          @RequestMapping(path = "/addCustomer",method = RequestMethod.POST)
        public String addCustomer(@ModelAttribute("customer")Customers customer){
            customer.setCustomersId(rand.nextInt());
            customerService.addCustomer(customer);
            
            return "redirect:allCustomers";
        }
       
	@RequestMapping("/getClients")
	public String getClients(Model model, @RequestParam("id") int id) {
		Customers client = customerService.getClient(id);
		model.addAttribute("client", client);
		
		return "showClient";
	}	
}
