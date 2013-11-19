package com.cebul.jez.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cebul.jez.entity.Produkty;
import com.cebul.jez.entity.ProduktyKupTeraz;
import com.cebul.jez.model.ProduktyDao;


@Service
public class ProduktyService 
{
	@Autowired
	private ProduktyDao produktyDao;
	
	@Transactional
	public List<String> getProduktyLike(String like)
	{
		return  produktyDao.getProduktyLike(like);
	}
	@Transactional
	public List<String> getProduktyLike(String like,Integer kategoria)
	{
		return produktyDao.getProduktyLike(like, kategoria);
	}
	@Transactional
	public boolean saveProduktKupTeraz(ProduktyKupTeraz p)
	{
		 return produktyDao.saveProduktKupTeraz(p);
	}
	@Transactional
	public Produkty getProdukt(Integer id)
	{
		return produktyDao.getProdukt(id);
	}
}
