package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.FileVO;
import vo.companyVo;
import vo.planVo;
import vo.policyName;

public class companyDao {
	List ls = new ArrayList();

	public List<companyVo> search() {
		// TODO Auto-generated method stub
		
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Query q = session.createQuery("from companyVo");
			ls = q.list();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}

	return ls;
	}
		
		public List<FileVO> searchfile(FileVO fileVO) {
			// TODO Auto-generated method stub
			
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

				Session session = sessionFactory.openSession();

				Query q = session.createQuery("from FileVO");
				ls = q.list();
			} 
			catch (HibernateException e) {
				e.printStackTrace();
			}

			return ls;


	}

	public List edit(companyVo covo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from companyVo where company_ID='"+covo.getCompany_ID()+"'");
		ls = q.list();

		tr.commit();
		return ls;

	}

	public List delete(companyVo covo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.delete(covo);

		tr.commit();
		return ls;

	}

	public void update(companyVo covo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.saveOrUpdate(covo);

		tr.commit();

	}

	

	public void insert(companyVo covo) {
		// TODO Auto-generated method stub
		try{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.save(covo);

		tr.commit();
		
		}
		 catch (HibernateException e) {
				e.printStackTrace();
			}


	}
	
	//Plan
	public List<planVo> search1() {
		// TODO Auto-generated method stub
		
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Query q = session.createQuery("from planVo");
			ls = q.list();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}

		return ls;

	}


	public List edit(planVo pvo) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from planVo where plan_id='"+pvo.getPlan_id()+"'");
		ls = q.list();

		tr.commit();
		return ls;

		// TODO Auto-generated method stub
		
	}

	public List delete(planVo pvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.delete(pvo);

		tr.commit();
		return ls;

	}

	public void update(planVo pvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.saveOrUpdate(pvo);

		tr.commit();

	}

	public void insert(planVo pvo) {
		// TODO Auto-generated method stub
		
		try{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.save(pvo);

		tr.commit();
		
		}
		 catch (HibernateException e) {
				e.printStackTrace();
			}
		
	}
	
	//policy name

	public List edit(policyName nvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from policyName where name_ID='"+nvo.getName_ID()+"'");
		ls = q.list();

		tr.commit();
		return ls;

	}

	public List delete(policyName nvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.delete(nvo);

		tr.commit();
		return ls;

	}

	public void update(policyName nvo) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();

		session.saveOrUpdate(nvo);

		tr.commit();

		
	}

	public void insert(policyName nvo) {
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(nvo);

			tr.commit();
			
			}
			 catch (HibernateException e) {
					e.printStackTrace();
				}
		
			}
	public List<policyName> search2() {
		// TODO Auto-generated method stub
		
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Query q = session.createQuery("from policyName");
			ls = q.list();
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}

		return ls;

	}

	public List loadPlan(companyVo vo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from planVo where cvo='"+vo.getCompany_ID()+"'");
		ls = q.list();

		tr.commit();
		return ls;
	}

	public void insertFile(FileVO fileVO) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(fileVO);

			tr.commit();
			
			}
			 catch (HibernateException e) {
					e.printStackTrace();
				}

	}

	public List viewDetails(FileVO fvo) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from FileVO where fileid='"+fvo.getFileid()+"'");
		ls = q.list();

		tr.commit();
		return ls;
		
	}

	
}
