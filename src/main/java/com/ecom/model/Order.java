package com.ecom.model;

import java.util.Date;

public class Order {
	
	private int id;
	private Date createdAt;
	private Product product;
	private User user;
	
	public Order(Product product, User user) {
		super();
		this.product = product;
		this.user = user;
	}

	public Order() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
