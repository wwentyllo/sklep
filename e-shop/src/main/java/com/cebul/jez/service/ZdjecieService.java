package com.cebul.jez.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cebul.jez.entity.Zdjecie;
import com.cebul.jez.model.ZdjecieDao;

@Service
public class ZdjecieService 
{
	@Autowired
	private ZdjecieDao zdjecieDao;
	
	@Transactional
	public boolean saveZdjecie(Zdjecie zdj)
	{
		return zdjecieDao.saveZdjecie(zdj);
	}
	@Transactional
	public Zdjecie getZdjecie(Integer id)
	{
		return zdjecieDao.getZdjecie(id);
	}
}
