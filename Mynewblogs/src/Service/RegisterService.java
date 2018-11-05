package Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Model.User;
@WebServlet("/RegisterService")
public class RegisterService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterService() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=utf-8");
    	 request.setCharacterEncoding("UTF-8");
    	 PrintWriter out=response.getWriter();
    	  String username=request.getParameter("userName");
    	  String pwd=request.getParameter("pwd");
    	  String phone=request.getParameter("phone");
    	  String qq=request.getParameter("qq");
    	  String email=request.getParameter("email");
    	  String info=request.getParameter("info");
    	  String avator=request.getParameter("avator");
    	  String id=request.getParameter("id");
    	  User user=new User();
    	  user.setId(Integer.parseInt(id));
    	  user.setUserName(username);
    	  user.setPwd(pwd);
    	  user.setEmail(email);
    	  user.setPhone(phone);
    	  user.setQq(qq);
    	  user.setInfo(info);
    	  user.setAvator(avator);
    	  UserRegister(user,out,response,request);
    	  System.out.println("1");
	}
	public void UserRegister(User user,PrintWriter out,HttpServletResponse response, HttpServletRequest request){
		  if((!String.valueOf(user.getId()).equals("")) && (!user.getUserName().equals("")) && (!user.getPwd().equals("")) &&(!user.getPhone().equals("")) &&(!user.getEmail().equals(""))){ 
			  	
				UserDao userdao=new UserDao();
				int num=userdao.InsertUser(user);
				if(num>0){
					out.println("¹§Ï²Äú×¢²á³É¹¦"+user.getUserName());
					response.setHeader("Refresh","3;login.jsp");
				}
				else{
					out.println("×¢²áÊ§°Ü£¬ÇëÖØĞÂ×¢²á");
					response.setHeader("Refresh","3;register.jsp");
				}
		  	}
		  }

}

















