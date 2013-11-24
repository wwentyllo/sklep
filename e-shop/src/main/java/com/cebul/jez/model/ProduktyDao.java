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
import com.cebul.jez.entity.Zdjecie;

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
		
		return result;
	}
	public List<Produkty> getFullProduktyLike(String like, Integer kategoria)
	{
		String l = "%"+like+"%";
		Session session = getSessionFactory();
		Query query = session.createQuery("from Produkty p " +
				"left join fetch p.kategorie as kat where " +
				"kat.id IN (select k.id from Kategoria k left join k.parentKategory as parentK " +
				"WHERE parentK.id = :kategoria ) and p.nazwa LIKE :like " +
				"and (p.id in (select i2.id from ProduktyKupTeraz i2 ) " +
				"or p.id in (select id2.id from ProduktyLicytuj id2 )  )  ")
				.setParameter("like", l).setParameter("kategoria", kategoria);
		List<Produkty> result = new ArrayList<Produkty>();
		if(!query.list().isEmpty())
			result = query.list();
		
		return result;
	}
	public List<Produkty> getFullProduktyLike(String like)
	{
		String l = "%"+like+"%";
		Session session = getSessionFactory();
		Query query = session.createQuery("from Produkty p " +
				"WHERE p.nazwa LIKE :like " +
				"and (p.id in (select i2.id from ProduktyKupTeraz i2 ) " +
				"or p.id in (select id2.id from ProduktyLicytuj id2 )  )  ")
				.setParameter("like", l);
		List<Produkty> result = new ArrayList<Produkty>();
		if(!query.list().isEmpty())
			result = query.list();
		
		return result;
	}
	public List<Produkty> getLastFourProdukt()
	{
		Session session = getSessionFactory();
		Query query = session.createQuery("from Produkty p where " +
				" (p.id in (select pk.id from ProduktyKupTeraz pk WHERE pk.kupiony = false) " +
				"or p.id in (select pl.id from ProduktyLicytuj pl WHERE pl.dataZakonczenia >= CURRENT_DATE() )) " +
				" ORDER BY p.dataDodania DESC").setMaxResults(6);
		List<Produkty> result = new ArrayList<Produkty>();
		if(!query.list().isEmpty())
			result = (List<Produkty>) query.list();
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
	public List<Integer> getZdjeciaId(Produkty p)
	{
		Session session = getSessionFactory();
		Query query = session.createQuery("select z.id from Prod_Zdj pz left join pz.produkt as p left join pz.zdjecie as z WHERE p.id = :idP ")
				.setParameter("idP", p.getId() );
		List<Integer> result = new ArrayList<Integer>();
		if(!query.list().isEmpty())
			result = (List<Integer>) query.list();
		//System.out.println(result.get(0).getNazwa());
		return result;
	}
	public Zdjecie getZdjecie(Integer id)
	{
		Session session = getSessionFactory();
		Query query = session.createQuery("from Zdjecie z where z.id = :idZ ")
				.setParameter("idZ", id);
		Zdjecie result = new Zdjecie();
		if(!query.list().isEmpty())
			result = (Zdjecie) query.list().get(0);
		//System.out.println(result.get(0).getNazwa());
		return result;
	}
	
}
