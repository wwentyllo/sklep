package com.cebul.jez.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cebul.jez.entity.User;

@Repository
public class UserDao 
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
	public void saveUser()
	{
		Session session = sessionFactory.getCurrentSession();
		User u = new User();
		session.save(u);
	}
	public boolean addUser(User u)
	{
		Session session = sessionFactory.getCurrentSession();
		boolean exsist = isExist(u);
		if(!exsist)
		{
			session.save(u);
			return true;
		}
		return false;
	}
	public boolean isExist(User user)
	{
		Session session = getSessionFactory();
		Query query = session.createSQLQuery("SELECT * FROM users WHERE login = :username ").
				addEntity(User.class).setParameter("username", user.getLogin());
		List<User> result = query.list();
		if(!result.isEmpty())
		{
			return true;
		}
		return false;
	}
	public void activeUser(Integer id)
	{
		Session session = sessionFactory.getCurrentSession();
		User u = (User) session.get(User.class, id);
		if(u.getEnabled() == 0)
		{
			u.setEnabled(1);
			session.update(u);
		}	
	}
	public User getUser(String login)
	{
		Session session = getSessionFactory();
		Query query = session.createSQLQuery("SELECT * FROM users WHERE login = :username ").
				addEntity(User.class).setParameter("username", login);
		List<User> result = query.list();
		return result.get(0);
	}
}
