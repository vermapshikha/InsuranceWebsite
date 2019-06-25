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

import vo.planVo;
import vo.RegVo_u;
import vo.portfolioVo;

public class RegDao_u {
	List ls = new ArrayList();

	public void insert(RegVo_u rvo) {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(rvo);

			tr.commit();

		} catch (Exception z) {
			z.printStackTrace();
		}
	}

	
	public List<RegVo_u> search() {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Query q = session.createQuery("from");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return ls;

	}
	public List loadName(planVo pvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from policyName where pvo='"+pvo.getPlan_id()+"'");
		ls = q.list();

		tr.commit();
		return ls;

	}


	public List search(portfolioVo povo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session =sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		Query q=session.createQuery("from RegVo where planid like'"+povo.getPvo().getPlan_id()+"' and companyid like'"+povo.getCvo().getCompany_ID()+"'");
		
		//SQLQuery query = session.createSQLQuery("Select * from policyguideline where planid like'"+povo.getPvo().getPlan_id()+"' and companyid like'"+povo.getCvo().getCompany_ID()+"'");
		
		List ls = q.list();
		
		return ls;
	}


	
}
