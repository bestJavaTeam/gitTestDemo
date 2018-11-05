package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Article;

public class ArtecleDao {
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
	// лМ╪сндуб
		public int insertArticle(Article article) {
			Connection con = null;
			PreparedStatement pest = null;

			try {
				con = getConnection();

				String sql = "insert into t_article(title,content,pub_date,user_id,articletype_id) values (?,?,?,?,?)";

				pest = con.prepareStatement(sql);
				pest.setString(1, article.getTitle());
				pest.setString(2, article.getContent());
				pest.setTimestamp(3, article.getPub_date());
				pest.setInt(4, article.getUser_id());
				pest.setInt(5, article.getArticletype_id());
				int rows = pest.executeUpdate();
				return rows;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return 0;
			} finally {
				
			}
		}
	
	

}
