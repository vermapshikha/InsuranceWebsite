package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.loginVo;

public class passwordDao {

	public List search(loginVo lvo) {
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session =sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		Query query = session.createQuery("from loginVo where userName='"+lvo.getUserName()+"'");
		
		List ls = query.list();
		
		return ls;

		// TODO Auto-generated method stub
		
	}

	public void update(loginVo lvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		SQLQuery q= session.createSQLQuery("Update LoginData Set Password='"+lvo.getPassWord()+"' Where LoginID='"+lvo.getLogin_ID()+"' ");
        q.executeUpdate();
		tr.commit();

		
	}

}
