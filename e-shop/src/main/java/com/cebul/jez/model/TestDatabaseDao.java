package com.cebul.jez.model;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDatabaseDao 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSessionFactory()
	{
		return sessionFactory.getCurrentSession();
	}
	
	private void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	public void testData1()
	{
		
	}
	
}
