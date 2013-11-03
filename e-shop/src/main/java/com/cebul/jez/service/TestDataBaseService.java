package com.cebul.jez.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cebul.jez.model.TestDatabaseDao;

@Service
public class TestDataBaseService 
{
	@Autowired
	private TestDatabaseDao testDao;
	
	@Transactional
	public void test1()
	{
		testDao.testData1();
	}
}
