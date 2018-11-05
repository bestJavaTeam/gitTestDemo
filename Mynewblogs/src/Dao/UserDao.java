package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



@SuppressWarnings("unused")
public class UserDao {
	final static String url="jdbc:mysql://localhost:3306/blog";
	final static String user="root";
	final static String password="qweasd@123456";
	private static Connection conn=null;
	@SuppressWarnings("finally")
	public  static Connection getConnection(){
			try {
				if (conn == null) {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(url, user, password);
				}
			}		
		catch (ClassNotFoundException  | SQLException e) {
			e.printStackTrace();
			
		}
		finally{
			return conn;
		}
	
	}
	public int InsertUser(Model.User user){
		if (user == null)
			return 0;
		Connection connection=getConnection();
		PreparedStatement pstatement=null;
		String sql = "INSERT INTO t_user VALUES(?,?,?,?,?,?,?,?) ";
		if(connection==null){
			return 0;
		}
		try {
			pstatement = connection.prepareStatement(sql);
			pstatement.setInt(1, user.getId());
			pstatement.setString(2, user.getUserName());
			pstatement.setString(3, user.getPwd());
			pstatement.setString(4,user.getEmail());
			pstatement.setString(5,user.getPhone());
			pstatement.setString(6, user.getQq());
			pstatement.setString(7, user.getInfo());
			pstatement.setString(8, user.getAvator());
			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	@SuppressWarnings("finally")
	public User SelectUser(String username,String pwd){
		User user=new User();
		Connection connection = getConnection();
		PreparedStatement pstatement = null;
		ResultSet result = null;
		if (connection == null)
			return null;
		String sql="select * from t_user where username=? and password=?";
		try {
			pstatement=connection.prepareStatement(sql);
			pstatement.setString(1,username);
			pstatement.setString(2,pwd);
			result=pstatement.executeQuery();
			while(result.next()){
				user.setUserName(result.getString("username"));
				user.setPwd(result.getString("password"));
				user.setId(result.getInt("id"));
				user.setEmail(result.getString("email"));
				user.setPhone(result.getString("phone"));
				user.setQq(result.getString("qq"));
				user.setInfo(result.getString("info"));
				user.setAvator(result.getString("avator"));
			}
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			return user;
		}
	}
	public int UpdateUser(User user,User nuser){
		Connection connection=getConnection();
		PreparedStatement  pstatement=null;
		if(connection==null){
			return 0;
		}
		String sql="update t_user set phone=?,userName=?,password=?,email=?,qq=?,info=?,avator=? where id=?";
		
		try {
			pstatement=connection.prepareStatement(sql);
			pstatement.setString(1, nuser.getPhone());
			pstatement.setString(2, nuser.getUserName());
			pstatement.setString(3, nuser.getPwd());
			pstatement.setString(4, nuser.getEmail());
			pstatement.setString(5, user.getQq());
			pstatement.setString(6, user.getInfo());
			pstatement.setString(7, user.getAvator());
			pstatement.setInt(8, user.getId());
			return pstatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	
	}
	 
	
	
	
	
	
	

}
