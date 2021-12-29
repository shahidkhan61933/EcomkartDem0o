package com.ecom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecom.model.Product;
import com.ecom.model.User;

public class ProductDAO {

	public final String READ_PRODUCTS = "select * from products";
	public final String READ_PRODUCTS_BY_ID = "select * from products where id = ?";
	public final String READ_PRODUCTS_BY_NAME = "select * from products where name=?";
	public final String ADD_PRODUCT = "insert into products(name,price) values(?,?)";
	public final String UPDATE_PRODUCT = "update products set name=?, price=? where id=?" ;
	public final String DELETE_PRODUCT = "delete from products where id=?";
	
	// jdbc template
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Product> getProducts() {
		@SuppressWarnings("deprecation")
		List<Product> products = template.query(READ_PRODUCTS, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getLong("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setDateAdded(rs.getDate("dateAdded"));
				return product;
			}
		});
		return products;
	}
	
	public Product getProductsById(int productId) {
		@SuppressWarnings("deprecation")
		Product product = template.queryForObject(READ_PRODUCTS_BY_ID,new Object[] {productId}, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getLong("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setDateAdded(rs.getDate("dateAdded"));
				return product;
			}
		});
		return product;
	}

	// add products
	public int addProduct(Product product) {
		return template.update(ADD_PRODUCT, new Object[] {product.getName(), product.getPrice()});
	}

	// updates products
	public int updateProduct(Product product) {
		return template.update(UPDATE_PRODUCT,new Object[] {product.getName(), product.getPrice(), product.getId()});
	}

	// delete products
	public int deleteProduct(Product product) {
		return template.update(DELETE_PRODUCT,new Object[] { product.getId()});
	}

}
