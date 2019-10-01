package com.pht.demoHibernate.model;
// Generated Oct 1, 2019 6:02:41 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Orders generated by hbm2java
 */
@Entity
@Table(name = "orders", catalog = "demo")
public class Orders implements java.io.Serializable {

	private int idorders;
	private Customer customer;
	private Item item;
	private Integer quantity;
	private String description;

	public Orders() {
	}

	public Orders(int idorders) {
		this.idorders = idorders;
	}

	public Orders(int idorders, Customer customer, Item item, Integer quantity, String description) {
		this.idorders = idorders;
		this.customer = customer;
		this.item = item;
		this.quantity = quantity;
		this.description = description;
	}

	@Id

	@Column(name = "idorders", unique = true, nullable = false)
	public int getIdorders() {
		return this.idorders;
	}

	public void setIdorders(int idorders) {
		this.idorders = idorders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcustomer")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iditem")
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
