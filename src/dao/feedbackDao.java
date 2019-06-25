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

import vo.feedbackVo;

public class feedbackDao {
	List ls = new ArrayList();
	
	public void insert(feedbackVo fvo) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(fvo);

			tr.commit();
			
			}
			 catch (HibernateException e) {
					e.printStackTrace();
				}


		}

	
	public List<feedbackVo> search() {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Query q = session.createQuery("from feedbackVo Where feedbackStatus='Active'");
			ls = q.list();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}

	return ls;
	}

	


	public List delete(feedbackVo fvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		SQLQuery s = session.createSQLQuery("Update feedback Set status='Deactive' Where feedback_ID =('"+fvo.getFeedback_ID()+"')");
        
		s.executeUpdate();
		
		return ls;

	}

}
