package com.qakj.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.springboot.mapper.CustomerMapper;
import com.qakj.springboot.pojo.Customer;
import com.qakj.springboot.pojo.CustomerExample;
import com.qakj.springboot.pojo.CustomerExample.Criteria;
import com.qakj.springboot.service.CustomerService;
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMapper mapper;
	@Override
	public List<Customer> getLimitById(int currentPage, int pageSize,String searchName) {
		mapper.getLimitById((currentPage - 1)*pageSize, pageSize, searchName);
		return null;
	}
	@Override
	public int getCount(String searchName) {
		CustomerExample example = new CustomerExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(searchName);
		int example2 = mapper.countByExample(example);
		return example2;
	}

}
