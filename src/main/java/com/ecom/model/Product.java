package com.ecom.model;

import java.util.Date;

public class Product {

	// properties
	private long id;
	private String name;
	private double price;
	private Date dateAdded;

	// constructor
	public Product() {}

	public Product(int id) {
		this.id = id;
	}
	
	public Product(long id, String name, double price, Date dateAdded) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
	}

	// getter & setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", dateAdded=" + dateAdded + "]";
	}
}
