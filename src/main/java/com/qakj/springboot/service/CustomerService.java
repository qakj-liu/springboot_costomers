package com.qakj.springboot.service;

import java.util.List;

import com.qakj.springboot.pojo.Customer;

public interface CustomerService {
	
	List<Customer> getLimitById(int currentPage,int pageSize,String searchName );
	int getCount(String searchName);
	
	
	
}
