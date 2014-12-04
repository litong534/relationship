package org;
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
	
//	public static void testSave(){
//		User u = new User();
//		u.setName("u1");
//		Group g = new Group();
//		g.setName("g1");
//		u.setGroup(g);
//		cfg = new Configuration().configure(); 
//        srb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
//        StandardServiceRegistry sr = srb.build();
//        sf = cfg.buildSessionFactory(sr);
//		Session session = sf.getCurrentSession();
//		session.beginTransaction();
//		session.save(u);
//		session.getTransaction().commit();
//	}
//	
//	public static void testGet(){
//		testSave();
//        Session session = sf.getCurrentSession();
//        session.beginTransaction();
//		User u1 = (User)session.load(User.class,1);
//		session.delete(u1);
//		session.getTransaction().commit();
//	}
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
//	public static void testDelete(Student s){
//		 cfg = new Configuration().configure(); 
//	        srb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
//	        StandardServiceRegistry sr = srb.build();
//	        sf = cfg.buildSessionFactory(sr);
//	        session = sf.openSession();
//	        session.beginTransaction();
//	        session.delete(s);
//	        session.getTransaction().commit();
//	        session.close();
//	        sf.close();
//	}
	public static void testmethod() {
		 cfg = new Configuration().configure(); 
        srb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        StandardServiceRegistry sr = srb.build();
        sf = cfg.buildSessionFactory(sr);
        session = sf.openSession();
        session.beginTransaction();
		Org o1 = new Org();
		o1.setName("o1");
		Org o2 = new Org();
		o2.setName("o2");
		Org o11 = new Org();
		o11.setName("o11");
		Org o12 = new Org();
		o12.setName("o12");
		Org org =new Org();
		org.setName("org");
		org.getChildren().add(o1);
		org.getChildren().add(o2);
		o1.getChildren().add(o11);
		o1.getChildren().add(o12);
		o1.setParent(org);
		o2.setParent(org);
		o11.setParent(o1);
		o12.setParent(o1);
		session.save(org);
		session.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.schemaExport();
		testmethod();
	}
	
	public void schemaExport(){
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
}