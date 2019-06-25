package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.cityVo;
import vo.countryVo;
import vo.stateVo;

public class countryDao {
	//COuntry
	List ls= new ArrayList();
	public List edit(countryVo cvo) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from countryVo where country_ID='"+cvo.getCountry_ID()+"'");
		ls = q.list();

		tr.commit();
		return ls;

	
		// TODO Auto-generated method stub
		
	}

	public void delete(countryVo cvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		SQLQuery q=session.createSQLQuery("Update country Set Status='Deactive' Where country_ID='"+cvo.getCountry_ID()+"'");

		q.executeUpdate();

		tr.commit();
	

		
	}

	public void update(countryVo cvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.saveOrUpdate(cvo);

		tr.commit();

		
	}

	public void insert(countryVo cvo) {
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

	public List search(countryVo cvo) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();
 
			Query q = session.createQuery("from countryVo Where countryStatus='Active'");
			ls = q.list();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}

		return ls;
	}

	//State
	
	public List edit(stateVo svo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from stateVo where state_ID='"+svo.getState_ID()+"'");
		ls = q.list();

		tr.commit();
		return ls;
		
	}

	public void delete(stateVo svo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		
		SQLQuery q=session.createSQLQuery("Update State set Status='Deactive' where ID='"+svo.getState_ID()+"'");

		q.executeUpdate();

		tr.commit();

	}

	public List search1(stateVo svo) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();
 
			Query q = session.createQuery("from stateVo Where stateStatus='Active'");
			ls = q.list();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}

		return ls;
	}

	public void update(stateVo svo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.saveOrUpdate(svo);

		tr.commit();

	}

	public void insert(stateVo svo) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(svo);

			tr.commit();
			
			}
			 catch (HibernateException e) {
					e.printStackTrace();
				}
		
	}
	
	//City
	
	public List edit(cityVo civo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from cityVo where city_ID='"+civo.getCity_ID()+"'");
		ls = q.list();

		tr.commit();
		return ls;

	}

	public void delete(cityVo civo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		SQLQuery q=session.createSQLQuery("Update city Set Status='Deactive' where city_ID='"+civo.getCity_ID()+"'");

		q.executeUpdate();

		tr.commit();

		
	}

	public List search3(cityVo civo) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();
 
			Query q = session.createQuery("from cityVo Where cityStatus='Active'");
			ls = q.list();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}

		return ls;

	}

	public void update(cityVo civo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.saveOrUpdate(civo);

		tr.commit();

	
	}

	public void insert(cityVo civo) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(civo);

			tr.commit();
			
			}
			 catch (HibernateException e) {
					e.printStackTrace();
				}
		
	}

	public List loadState(countryVo vo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from stateVo where cvo='"+vo.getCountry_ID()+"'");
		ls = q.list();

		tr.commit();
		return ls;

	}

	public List loadCity(stateVo stvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from cityVo where svo='"+stvo.getState_ID()+"'");
		ls = q.list();

		tr.commit();
		return ls;

	}


}
