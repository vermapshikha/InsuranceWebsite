package dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.clientVo;
import vo.policyVo;


public class agentDao {
	List ls = new ArrayList();

	public List<clientVo> search() {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Query q = session.createQuery("from clientVo");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return ls;

	}


	public List edit(clientVo cvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from clientVo where id='"+cvo.getId()+"'");
		ls = q.list();

		tr.commit();
		return ls;
	}

	public List delete(clientVo cvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.delete(cvo);

		tr.commit();
		return ls;
	}



	public void update(clientVo cvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.saveOrUpdate(cvo);

		tr.commit();
		
	}


	public void insert(clientVo cvo) {
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


	public void insert(policyVo pvo) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(pvo);

			tr.commit();

		} catch (Exception z) {
			z.printStackTrace();
		}

	}


	public List edit(policyVo pvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from policyVo where policy_Id='"+pvo.getPolicy_Id()+"'");
		ls = q.list();

		tr.commit();
		return ls;

	}


	public List delete(policyVo pvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.delete(pvo);

		tr.commit();
		return ls;
	}
	
		public List<policyVo> search1() {
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

				Session session = sessionFactory.openSession();

				Query q = session.createQuery("from policyVo");
				ls = q.list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return ls;

	}


		public void update(policyVo pvo) {
			// TODO Auto-generated method stub
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.saveOrUpdate(pvo);

			tr.commit();
			
			
		}
}