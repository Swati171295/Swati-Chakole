package com.web.MVCMavenWebDemo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.web.MVCMavenWebDemo.model.UserModel;

public interface UserDao {
	public Connection getConnection();
	public void insertUser (UserModel model)throws SQLException;
	public boolean updateUser (UserModel model) throws SQLException;
	public UserModel selectUser (int id);
	public List<UserModel> selectAllUser();
	public boolean deleteUser (int id) throws SQLException;

}
