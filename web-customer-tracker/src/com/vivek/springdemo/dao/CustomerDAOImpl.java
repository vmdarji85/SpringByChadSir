package com.vivek.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vivek.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	//add session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		//create query
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		//execute query and get result list
		List<Customer> customers = query.getResultList();
		// return result
		return customers;
	}

	@Override
	
	public void saveCustomer(Customer theCustomer) {
		//get current Session
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	
	public Customer getCustomer(int theId) {
		//get Currentsession
		Session session = sessionFactory.getCurrentSession();
		//get customer from db
		Customer customer = session.get(Customer.class, theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		//get Current Session
		Session session  = sessionFactory.getCurrentSession();
		//write hibernate query to delete customer
		Query query = session.createQuery("delete from Customer where id=:customerId");
		//set parameter
		query.setParameter("customerId", theId);
		//execute query
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		//get current session
		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery= null;
		
		if(theSearchName != null && theSearchName.length()>0) {

			String sql = "from Customer where lower(firstName) like :theName or lower(lastName) like :theName";
			theQuery = session.createQuery(sql, Customer.class);
			//set parameter
			theQuery.setParameter("theName", "%"+theSearchName.toLowerCase()+"%");
		} else {
			//return all customer
			theQuery = session.createQuery("from Customer", Customer.class);
		}
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	

	

}
