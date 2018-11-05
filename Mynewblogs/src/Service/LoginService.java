package Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Model.User;





/**
 * Servlet implementation class LoginService
 */
@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginService() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
   	 PrintWriter out=response.getWriter();
   	  String username=request.getParameter("userName");
   	  String pwd=request.getParameter("pwd");
   	  User user=new User();
   	  UserDao userdao=new UserDao();
   	  user=userdao.SelectUser(username,pwd);
   	  if(user.getUserName()!=null && user.getPwd()!=null){
   		  if(user.getUserName().equals("root")){
   			  out.println("»¶Ó­Äú¹ÜÀíÔ±");
   			  HttpSession session = request.getSession();
   			  session.setAttribute("user", user);
   			  request.getRequestDispatcher("root.jsp").forward(request, response);
   		  
     			}
   		  else {
   			  out.println("¹§Ï²ÄúµÇÂ½³É¹¦"+user.getUserName());
   			  HttpSession session = request.getSession();
   			  session.setAttribute("username", user.getUserName());
   			  session.setAttribute("user", user);
   			  HttpSession se = request.getSession();
   			  se.setMaxInactiveInterval(900*24);
   			  response.setHeader("Refresh","1;Commodity.jsp");
   		  }
   	  }
   	  else{
   		 out.println("ÇëÄúÖØÐÂµÇÂ¼");
   		 response.setHeader("Refresh", "3;login.jsp");
   		 }
	}

}
