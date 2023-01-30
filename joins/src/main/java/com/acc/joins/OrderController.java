package com.acc.joins;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@PostMapping("/postdata")
	public CustomerEntity placeOrder(@RequestBody OrderRequest request) {
		return customerRepo.save(request.getCustomerEntity());
	}
	
	@GetMapping("/getdata")
	public List<CustomerEntity> findAllOrder(){
		return customerRepo.findAll();
	}
	
	@GetMapping("/leftjoin")
	public List<OrderResponce> getLeftJoin(){
		return customerRepo.getLeftJoin();
	}
	
	@GetMapping("/rightjoin")
	public List<OrderResponce> getRightJoin(){
		return customerRepo.getRightJoin();
	}
	
	
	@GetMapping("/innerjoin")
	public List<OrderResponce> getInnerJoin(){
		return customerRepo.getLeftJoin();
	}
	
	@GetMapping("/crossjoin")
	public List<OrderResponce> getCrossJoin(){
		return productRepo.getCrossJoin();
	}
	
	@GetMapping("/inner")
	public List<OrderResponce> getInner(){
		return customerRepo.getInner();
	}
	
}
