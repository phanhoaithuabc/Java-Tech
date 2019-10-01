package com.pht.demoHibernate;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.*;

public class App {
	 private static SessionFactory factory;
	 
	 public static void main(String[] args) {
	  try {
	   factory = new Configuration().configure().buildSessionFactory();
	  } catch (Throwable ex) {
	   ex.printStackTrace();
	  }
	  App ME = new App();
	 
	  // Add few customer records in database
	  Integer cusID1 = ME.addCustomer(8, "nguyen khanh B", "USA");
	  Integer cusID2 = ME.addCustomer(9, "nguyen khanh A", "Australia");
	  
	  // List down all the customer
	  ME.listCustomer();
	 
	  // Update customer's records
	  ME.updateCustomer(cusID1, "Binh Dinh");
	 
	  // Delete an employee from the database
	  ME.deleteCustomer(cusID2);
	 
	  // List down new list of the employees
	  ME.listCustomer();
	 }
	 
	 // Method to CREATE an employee in the database
	 public Integer addCustomer(int id, String name, String address) {
	  Session session = factory.openSession();
	  Transaction tx = null;
	  Integer customerID = null;
	  try {
	   tx = session.beginTransaction();
	   Customer customer = new Customer(id, name, address);
	   customerID = (Integer) session.save(customer);
	   tx.commit();
	  } catch (HibernateException e) {
	   if (tx != null)
	    tx.rollback();
	   e.printStackTrace();
	  } finally {
	   session.close();
	  }
	  return customerID;
	 }
	 
	 // Method to READ all the employees
	 public void listCustomer() {
		  Session session = factory.openSession();
		  Transaction tx = null;
		  try {
		   tx = session.beginTransaction();
		   List employees = session.createQuery("FROM Customer").list();
		   for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Customer customer = (Customer) iterator.next();
		    System.out.print("ID Customer: " + customer.getIdcustomer());
		    System.out.print("  Name: " + customer.getName());
		    System.out.println("  Address: " + customer.getAddress());
		   }
		   tx.commit();
		  } catch (HibernateException e) {
		   if (tx != null)
		    tx.rollback();
		   e.printStackTrace();
		  } finally {
		   session.close();
		  }
		 }
	 
	 // Method to UPDATE salary for an employee
	 public void updateCustomer(Integer CustomerID, String address) {
	  Session session = factory.openSession();
	  Transaction tx = null;
	  try {
	   tx = session.beginTransaction();
	   Customer customer = (Customer) session.get(Customer.class, CustomerID);
	   customer.setAddress(address);
	   session.update(customer);
	   tx.commit();
	  } catch (HibernateException e) {
	   if (tx != null)
	    tx.rollback();
	   e.printStackTrace();
	  } finally {
	   session.close();
	  }
	 }
	 
	 // Method to DELETE an employee from the records
	 public void deleteCustomer(Integer CustomerID) {
	  Session session = factory.openSession();
	  Transaction tx = null;
	  try {
	   tx = session.beginTransaction();
	   Customer customer = (Customer) session.get(Customer.class, CustomerID);
	   session.delete(customer);
	   tx.commit();
	  } catch (HibernateException e) {
	   if (tx != null)
	    tx.rollback();
	   e.printStackTrace();
	  } finally {
	   session.close();
	  }
	 }
	}