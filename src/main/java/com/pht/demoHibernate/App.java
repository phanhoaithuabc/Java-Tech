package com.pht.demoHibernate;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pht.demoHibernate.model.*;

import antlr.collections.List;

public class App {
	 private static SessionFactory factory;
	 
	 public static void main(String[] args) {
	  try {
	   factory = new Configuration().configure().buildSessionFactory();
	  } catch (Throwable ex) {
	   ex.printStackTrace();
	  }
	  App ME = new App();
	 
	  // Add few employee records in database
	  Integer empID1 = ME.addCustomer(5, "nguyen khanh", "viet nam",);
	 
	  // List down all the employees
	  //ME.listEmployees();
	 
	  // Update employee's records
	  //ME.updateEmployee(empID1, 5000);
	 
	  // Delete an employee from the database
	  //ME.deleteEmployee(empID2);
	 
	  // List down new list of the employees
	  //ME.listEmployees();
	 }
	 
	 // Method to CREATE an employee in the database
	 public Integer addCustomer(String id, String name, String address) {
	  Session session = factory.openSession();
	  Transaction tx = null;
	  Integer employeeID = null;
	  try {
	   tx = session.beginTransaction();
	   Customer customer = new Customer(id, name, address, );
	   employeeID = (Integer) session.save(customer);
	   tx.commit();
	  } catch (HibernateException e) {
	   if (tx != null)
	    tx.rollback();
	   e.printStackTrace();
	  } finally {
	   session.close();
	  }
	  return employeeID;
	 }
	 
	 // Method to READ all the employees
	 
	 
	 // Method to UPDATE salary for an employee
	 public void updateEmployee(Integer EmployeeID, int salary) {
	  Session session = factory.openSession();
	  Transaction tx = null;
	  try {
	   tx = session.beginTransaction();
	   Customer employee = (Customer) session.get(Customer.class, EmployeeID);
	   employee.getAddress();
	   session.update(employee);
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
	 public void deleteEmployee(Integer EmployeeID) {
	  Session session = factory.openSession();
	  Transaction tx = null;
	  try {
	   tx = session.beginTransaction();
	   Customer customer = (Customer) session.get(Customer.class, EmployeeID);
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