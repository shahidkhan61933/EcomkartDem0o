package com.ecom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecom.model.Order;
import com.ecom.model.Product;
import com.ecom.model.User;

public class OrderDAO {

	
	public final String ADD_ORDER = "insert into orders(userId,productId) values(?,?)";
	public final String READ_ORDER_BY_ID = "select * from orders where id = ?";
	public final String READ_ORDERS = "select * from orders ";
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	UserDAO userDao;
	
	// jdbc template
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// add order
	public int addOder(int userId,int productId) {
		return template.update(ADD_ORDER, new Object[] { userId, productId });
	}
	
	public Order getOrder(int orderId) {
		@SuppressWarnings("deprecation")
		Order order = template.queryForObject(READ_ORDER_BY_ID,new Object[] { orderId}, new RowMapper<Order>() {
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order order = new Order();
				//get product by id;
				Product product = productDao.getProductsById(rs.getInt("productId"));
				//get user id				
				User user = userDao.getUserById(rs.getInt("userId"));
				
				//set oder filesds
				order.setId(rs.getInt("id"));
				order.setProduct(product);
				order.setUser(user);
				
				return order;
			}
		});
		return order;
	}
	
	public List<Order> getOrders() {
		@SuppressWarnings("deprecation")
		List<Order> orders = template.query(READ_ORDERS, new RowMapper<Order>() {
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order order = new Order();
				//get product by id;
				Product product = productDao.getProductsById(rs.getInt("productId"));
				//get user id				
				User user = userDao.getUserById(rs.getInt("userId"));
				
				//set oder filesds
				order.setId(rs.getInt("id"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setProduct(product);
				order.setUser(user);
				
				return order;
			}
		});
		return orders;
	}
}
