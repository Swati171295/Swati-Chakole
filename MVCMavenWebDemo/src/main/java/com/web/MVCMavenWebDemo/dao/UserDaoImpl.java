package com.web.MVCMavenWebDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.MVCMavenWebDemo.model.UserModel;

public class UserDaoImpl implements UserDao {
	
	private static String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users "+ "(name) VALUES" +"(?); ";
	
	private static final String SELECT_USER_BY_ID = "select * from users where id = ?;";
	private static final String SELECT_ALL_USERS = "select * from users;";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String  UPDATE_USERS_SQL = "update users set id = ?, name = ? where id = ?;";

	@Override
	public  Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}catch(Exception e){
			e.printStackTrace();
		}
		return connection;	
	}
	//insert user
	@Override
	public void insertUser (UserModel model) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =connection.prepareStatement(INSERT_USERS_SQL)){
		//	preparedStatement.setInt(1, model.getId());
			preparedStatement.setString(1, model.getName());
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
 //update users
	@Override
	public boolean updateUser (UserModel model) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_USERS_SQL)){
			preparedStatement.setInt(1, model.getId());
			preparedStatement.setString(2, model.getName());
			preparedStatement.setInt(3, model.getId());
			rowUpdated = preparedStatement.executeUpdate()>0;
			
		}
		return rowUpdated;
		
	}
	//select user by id
	@Override
	public UserModel selectUser (int id){
		UserModel bean = null; 
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =connection.prepareStatement(SELECT_USER_BY_ID)){
			
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				bean =  new UserModel(id, name);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	//select All Users
	@Override
	public List<UserModel> selectAllUser (){
		List<UserModel> models = new ArrayList< >(); 
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_USERS)){
			
		//	preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				models.add(new UserModel(id, name));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return models;
	}
//delete user
	@Override
	public boolean deleteUser (int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =connection.prepareStatement(DELETE_USERS_SQL)){
			
				preparedStatement.setInt(1, id);
				rowDeleted = preparedStatement.executeUpdate()>0;
			
		}
		return rowDeleted;
		
	}

	
}
