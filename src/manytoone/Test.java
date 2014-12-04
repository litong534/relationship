package manytoone;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Test {
	static Configuration cfg = null;
	static StandardServiceRegistryBuilder srb = null;
	static SessionFactory sf = null;
	static Session session = null;
	
	public static void testSave(){
		Group g = new Group();
		g.setName("g1");
		User u1 = new User();
		u1.setName("u1");
		u1.setGroup(g);
		User u2 = new User();
		u2.setName("u2");
		u2.setGroup(g);
		User u3 = new User();
		u3.setName("u3");
		u3.setGroup(g);
		User u4 = new User();
		u4.setName("u4");
		u4.setGroup(g);
		User u5 = new User();
		u5.setName("u5");
		u5.setGroup(g);
		User u6 = new User();
		u6.setName("u6");
		u6.setGroup(g);
		User u7 = new User();
		u7.setName("u7");
		u7.setGroup(g);
		cfg = new Configuration().configure(); 
        srb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        StandardServiceRegistry sr = srb.build();
        sf = cfg.buildSessionFactory(sr);
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(u1);
		session.save(u2);
		session.save(u3);
		session.save(u4);
		session.save(u5);
		session.save(u6);
		session.save(u7);
		session.getTransaction().commit();
	}
	
	public static void testGet(){
		testSave();
        Session session = sf.getCurrentSession();
        session.beginTransaction();
		User u1 = (User)session.load(User.class,1);
		session.delete(u1);
		session.getTransaction().commit();
	}
//	
//	public static void testUpdate(Student s){
//		 cfg = new Configuration().configure(); 
//	        srb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
//	        StandardServiceRegistry sr = srb.build();
//	        sf = cfg.buildSessionFactory(sr);
//	        session = sf.openSession();
//	        session.beginTransaction();
//	        session.update(s);
//	        session.getTransaction().commit();
//	        session.close();
//	        sf.close();
//	}
//	
	public static void test1N(){
		 cfg = new Configuration().configure(); 
	        srb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
	        StandardServiceRegistry sr = srb.build();
	        sf = cfg.buildSessionFactory(sr);
	        session = sf.openSession();
	        session.beginTransaction();
	        List<User> users = session.createCriteria(User.class).list();
	        for(User u:users){
	        	System.out.println(u.getName());
	        }
	        session.getTransaction().commit();
	        session.close();
	        sf.close();
	}
	
	public static void main(String[] args) {
//		Test test = new Test();
//		test.schemaExport();
//		testSave();
		test1N();
	}
	
	public void schemaExport(){
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
}