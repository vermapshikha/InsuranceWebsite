package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.RegVo;
import vo.planVo;
import vo.policyName;

public class RegDao {
	List ls = new ArrayList();

	public void insert(RegVo rvo) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(rvo);

			tr.commit();

		} catch (Exception z) {
			z.printStackTrace();
		}
	}

	public List edit(RegVo rvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from RegVo where pg_id='" + rvo.getPg_id()+"'");
		ls = q.list();

		tr.commit();
		return ls;
	}

	public List delete(RegVo rvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.delete(rvo);

		tr.commit();
		return ls;

	}

	public List<RegVo> search() {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Query q = session.createQuery("from RegVo");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return ls;

	}

	public void update(RegVo rvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.saveOrUpdate(rvo);

		tr.commit();

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


}
