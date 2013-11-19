package com.cebul.jez.model;

import java.io.File;

import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.cebul.jez.entity.Zdjecie;


@Repository
public class ZdjecieDao extends Dao
{
	
	public boolean saveZdjecie(Zdjecie zdj)
	{
		try{
			Session session = getSessionFactory();
			session.save(zdj);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public Zdjecie getZdjecie(Integer id)
	{
		Zdjecie zdj = new Zdjecie();
		Session session = getSessionFactory();
		zdj = (Zdjecie) session.get(Zdjecie.class, id);
		return zdj;
		
	}
}
