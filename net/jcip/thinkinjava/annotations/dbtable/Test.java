//package net.jcip.thinkinjava.annotations.dbtable;
//
//import java.io.UnsupportedEncodingException;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import com.HibernateSessionFactory;
//
//public class Test {
//
//	/**
//	 * @param args
//	 * @throws UnsupportedEncodingException
//	 */
//	public static void main(String[] args) throws UnsupportedEncodingException {
//		// TODO Auto-generated method stub
//		Session s=HibernateSessionFactory.getSession();
//		Transaction tx=s.beginTransaction();
//		Department dep=new Department();
//		String str = new String("�������2011");
//		dep.setDepFlag("1");
//		dep.setDepName(str);
//		s.save(dep);
//		tx.commit();
//		s.close();
//
//	}
//
//	}
//
//
