package com.cache.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cache.model.Employee;

@Service
public class DataServiceImpl {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void firstLevelCache() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Employee e1 = session.get(Employee.class, new Integer(1));
		// System.out.println(e1);

		Employee e2 = session.load(Employee.class, new Integer(3));
		// System.out.println(e2);

		/*
		 * Session s1 = sessionFactory.openSession(); Transaction t1 =
		 * s1.beginTransaction(); Employee e3 = s1.load(Employee.class, new Integer(1));
		 * 
		 * System.out.println(e3);
		 */
		transaction.commit();
		session.clear();

		// t1.commit();

		// s1.clear();

	}

	public void add(Employee e) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		session.save(e);
		transaction.commit();
		// session.flush();

	}

	public void updateEmployee() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();

		Employee e = session.get(Employee.class, 2);
		session.close();
		e.setName("changed!");
		Session session1 = sessionFactory.openSession();
		Transaction transaction = session1.beginTransaction();
		session1.merge(e);
		transaction.commit();
		session1.close();

	}

}
