package com.ecom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ecom.model.Login;
import com.ecom.model.Product;
import com.ecom.model.User;

public class UserDAO {
	
	public final String INSERT_USER = "insert into users(username,password,firstname,lastname,email,address,phone)  values(?,?,?,?,?,?,?)";
	public final String LOGIN_USER = "select * from users where username=? and password=?";
	public final String READ_USER_BY_ID = "select * from users where id = ?";
	
	//jdbc template
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// add user
	public int createUser(User user) {
		return template.update(INSERT_USER, new Object[] {user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),
				user.getEmail(), user.getAddress(), user.getPhone()});
	}
	
	// get user
	public List<User> loginUser(Login login) { 

		@SuppressWarnings("deprecation")
		List<User> users = template.query(LOGIN_USER, new Object[] {login.getUsername(), login.getPassword()}, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user= new User();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				return user;
			}
		});
		return users;
	}
	
	public User getUserById(int userId) {
		@SuppressWarnings("deprecation")
		User user = template.queryForObject(READ_USER_BY_ID,new Object[] {userId}, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				return user;
			}
		});
		return user;
	}
	
}
