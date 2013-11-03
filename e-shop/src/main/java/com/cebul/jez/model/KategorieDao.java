package com.cebul.jez.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cebul.jez.entity.Kategoria;

@Repository
public class KategorieDao 
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
	
	public List<Kategoria> getMainKategory()
	{
		Session session = getSessionFactory();
		Query query = session.createSQLQuery("SELECT * FROM Kategorie WHERE IdParentKat is null").
				addEntity(Kategoria.class);
		List<Kategoria> result = query.list();
		return result;
		
	}
	public List<Kategoria> getPodKategory(String parent)
	{
		
		Session session = getSessionFactory();
		Query query = session.createSQLQuery("SELECT * FROM Kategorie WHERE IdParentKat = :parent").
				addEntity(Kategoria.class).setParameter("parent", parent);
			
		List<Kategoria> result = query.list();
		return result;
	}
	
}
