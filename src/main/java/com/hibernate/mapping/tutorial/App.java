package com.hibernate.mapping.tutorial;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sessionfactory.util.SessionFactoryUtil;

import one.to.many.mapping.Address;
import one.to.one.mapping.Laptop;
import one.to.one.mapping.Student;

/**
 * 
 *
 */
public class App {
    public static void main( String[] args ) {

    	 final SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
    	 Session session = sessionFactory.openSession();
    	 oneToOneAndOneToManyExample(session);
    	 ManyToManyExample(session);
    }

	private static void ManyToManyExample(Session session) {
		
		
	}

	private static void oneToOneAndOneToManyExample(Session session) {
		Student student = new Student();
		student.setFirstName("Bharat");
		student.setLastName("Bhooshan");
		student.setContactNumber(984731518);
		
		
		Laptop laptop = new Laptop();
		laptop.setLaptopMacAddress("04-EA-56-36-B8-07");
		laptop.setLaptopName("Dell");
        student.setLaptop(laptop);
        
        Address address = new Address();
        address.setCity("Sitapur");
        address.setCountry("India");
        address.setHouseNumber("13/113");
        address.setPost("Khairabad");
        address.setState("UP");
        address.setPincode(261131);
        address.setLocality("Mahendri Tola");
        address.setIsPrimaryAddress(true);
        
        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
		student.setAddresses(addresses);
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
        session.close();
	}
}
