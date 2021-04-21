package com.order.controller;



import java.util.List;

import org.hibernate.StaleStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.OrderRequest;
import com.order.entity.Orders;
import com.order.repository.OrderRepository;
import com.order.repository.ProductRepository;

@RestController
/* @RequestMapping(value="/order") */
public class OrderController {

	/*
	 * @Autowired private OrderServices orderServices;
	 */
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/placeOrder")
	public Orders placeOrder(@RequestBody OrderRequest request)throws StaleStateException {
		return orderRepository.save(request.getOrders());
	}

	@GetMapping("/findAllOrders")
	public List<Orders> findAllOrders() throws StaleStateException{
		List<Orders> order= orderRepository.findAll();
		return order;
	}
	
	@GetMapping("/findById/{id}")
	public Orders  findAById(@PathVariable String id){
		return orderRepository.findOne(Integer.parseInt(id));
	
	}
	 @DeleteMapping("/deleteBy/{id}")
	  void deleteBy(@PathVariable String id) {
		 Orders order=orderRepository.findOne(Integer.parseInt(id));
		productRepository.delete(order.getProducts());
		 orderRepository.delete(order.getOrderId());
		 
	  }
	 
	 @PutMapping("/UpdateById/{id}")
		public Orders  UpdateById(@RequestBody OrderRequest request){
	Integer id=	 request.getOrders().getOrderId();
			Orders order= orderRepository.findOne(id);
		order.setOrderDescription((request.getOrders().getOrderDescription()));
			return orderRepository.save(order);
		}
	 
	
}
