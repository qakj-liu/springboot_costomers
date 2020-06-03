package com.qakj.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.springboot.pojo.Customer;
import com.qakj.springboot.service.CustomerService;
@RequestMapping("/customerController")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@RequestMapping("/getLimit")
	public Map<String,Object> getLimit(@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize,@RequestParam("searchName") String searchName){
		if(searchName == null || "".equals(searchName)){
			searchName = "%%";
		}else{
			searchName ="%"+searchName+"%";
		}
		
		List<Customer> list = cs.getLimitById(currentPage, pageSize, searchName);
		int count = cs.getCount(searchName);
		int countPage = count % pageSize == 0?count / pageSize:(count / pageSize)+1;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("countPage", countPage);
		return map;
	}
}
