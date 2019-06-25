package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.agentVo;

public class agentRegDao {

	public void insert(agentVo avo) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(avo);

			tr.commit();
			
			}
			 catch (HibernateException e) {
					e.printStackTrace();
				}


	}

}
