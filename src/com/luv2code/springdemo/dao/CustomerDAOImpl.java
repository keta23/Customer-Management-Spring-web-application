package com.luv2code.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//inject sessionfactory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		//get current session
	Session currentsession	=sessionFactory.getCurrentSession();
		
		//create query and get result
	      Query<Customer>  query=currentsession.createQuery("from Customer order by lastName ",Customer.class);
	     List<Customer> customers= query.getResultList();
		
		//return list of customer
		
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer thecustomer) {
		//get current session
		Session currentsession	=sessionFactory.getCurrentSession();
		//save object if primary key is null inser otherwise update
	      currentsession.saveOrUpdate(thecustomer);
		
		
	}

	@Override
	public Customer getCustomer(int theid) {
		//get current session
		Session currentsession	=sessionFactory.getCurrentSession();
			
			//create query and get result
		   Customer thecustomer= currentsession.get(Customer.class, theid);
		    
		return thecustomer;
	}

	@Override
	public void deleteCustomer(int theid) {
		
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery("delete from Customer where id=:customerId",Customer.class);
				theQuery.setParameter("customerId", theid);
				
				theQuery.executeUpdate();
		
	}

}
