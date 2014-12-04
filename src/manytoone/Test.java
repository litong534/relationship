package manytoone;
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
		User u = new User();
		u.setName("u1");
		Group g = new Group();
		g.setName("g1");
		u.setGroup(g);
		cfg = new Configuration().configure(); 
        srb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        StandardServiceRegistry sr = srb.build();
        sf = cfg.buildSessionFactory(sr);
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(u);
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
		User u1 = new User();
		u1.setName("u1");
		User u2 = new User();
		u2.setName("u2");
		u1=u2;
		System.out.println(u1.getName());
		u2=null;
		System.out.println(u1.getName());
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.schemaExport();
		testGet();
	}
	
	public void schemaExport(){
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
}