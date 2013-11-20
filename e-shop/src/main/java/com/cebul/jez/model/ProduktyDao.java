package com.cebul.jez.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cebul.jez.entity.Kategoria;
import com.cebul.jez.entity.Produkty;
import com.cebul.jez.entity.ProduktyKupTeraz;
import com.cebul.jez.entity.ProduktyLicytuj;
import com.cebul.jez.entity.User;

@Repository
public class ProduktyDao extends Dao
{
	public List<String> getProduktyLike(String like)
	{
		String l = "%"+like+"%";
		Session session = getSessionFactory();
		Query query = session.createQuery("select p.nazwa from Produkty p where " +
				" p.nazwa LIKE :like and  (p.id in (select i2.id from ProduktyKupTeraz i2 ) " +
				"or p.id in (select id2.id from ProduktyLicytuj id2 ))  GROUP BY p.nazwa ")
				.setParameter("like", l);
		List<String> result = new ArrayList<String>();
		if(!query.list().isEmpty())
			result = (List<String>) query.list();
		//System.out.println(result.get(0).getNazwa());
		return result;
	}
	public List<String> getProduktyLike(String like, Integer kategoria)
	{
		String l = "%"+like+"%";
		Session session = getSessionFactory();
		Query query = session.createQuery("select p.nazwa from Produkty p " +
				"left join fetch p.kategorie as kat where " +
				"kat.id IN (select k.id from Kategoria k left join k.parentKategory as parentK " +
				"WHERE parentK.id = :kategoria ) and p.nazwa LIKE :like " +
				"and (p.id in (select i2.id from ProduktyKupTeraz i2 ) " +
				"or p.id in (select id2.id from ProduktyLicytuj id2 ) GROUP BY p.nazwa )  ")
				.setParameter("like", l).setParameter("kategoria", kategoria);
		List<String> result = new ArrayList<String>();
		if(!query.list().isEmpty())
			result = query.list();
		
		//System.out.println(result.get(0).getNazwa());
		return result;
	}
	public Produkty getProdukt(Integer id)
	{
		Produkty p = new Produkty();
		Session session = getSessionFactory();
		p = (Produkty) session.get(Produkty.class, id);
		return p;
		
	}
	public boolean saveProduktKupTeraz(ProduktyKupTeraz p)
	{
		try{
			Session session = getSessionFactory();
			Kategoria kat = (Kategoria) session.get(Kategoria.class, p.getKategorie().getId());
			p.setKategorie(kat);
			session.saveOrUpdate(p);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public boolean updateProdukt(Produkty p)
	{
		try{
			Session session = getSessionFactory();
			session.saveOrUpdate(p);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public boolean saveProduktLicytuj(ProduktyLicytuj p)
	{
		try{
			Session session = getSessionFactory();
			Kategoria kat = (Kategoria) session.get(Kategoria.class, p.getKategorie().getId());
			p.setKategorie(kat);
			session.saveOrUpdate(p);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
}
