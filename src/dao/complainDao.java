package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.complainVo;

public class complainDao {
	List ls=new ArrayList();
	
	
	public List replyComplain(complainVo cvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q=session.createQuery("from complainVo where complainID='"+cvo.getComplainID()+"'");
		 List ls =q.list();
		 tr.commit();
		 return ls;
	}
	

	public void replyInsert(complainVo cvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(cvo);
		tr.commit();
	}


	public List search() {
		// TODO Auto-generated method stub
		
		List ls=new ArrayList();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from complainVo");
		ls=q.list();
		
		return ls;
	}
	

	public List searchAdmin() {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Query q = session.createQuery("from loginVo Where User_type='admin'");
			ls = q.list();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}

	return ls;
	}



	public void insert(complainVo cvo) {
		// TODO Auto-generated method stub
		
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(cvo);

			tr.commit();
			
			}
			 catch (HibernateException e) {
					e.printStackTrace();
				}


		}


	public List searchReply(complainVo vo) {
		// TODO Auto-generated method stub
		List ls=new ArrayList();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from complainVo Where complainStatus='Replied' AND complainTo='"+vo.getComplainTo().getLogin_ID()+"'");
		ls=q.list();
		
		return ls;
	}
}
