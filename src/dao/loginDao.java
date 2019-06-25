package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.loginVo;

public class loginDao {

	public void insert(loginVo lvo) {
		// TODO Auto-generated method stub
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(lvo);
			
			tr.commit();
			
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		
	}

	public List authentication(loginVo loginVO) {
		// TODO Auto-generated method stub
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session =sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		Query query = session.createQuery("from loginVo where userName='"+loginVO.getUserName()+"' and passWord='"+loginVO.getPassWord()+"'");
		
		List ls = query.list();
		
		return ls;
	}

}
