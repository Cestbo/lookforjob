package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import entity.User;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean1.xml");
		UserDao userDao=(UserDao)context.getBean("userDao");
		if (action.equals("login")) {

			String name=request.getParameter("name");
			String password=request.getParameter("password");
			
			User hr=userDao.getByName(name);
			String ranStr=(String) request.getSession().getAttribute("ranStr");
			String validate=request.getParameter("validate");
			if(hr!=null && password.equals(hr.getPassword()) && validate.equals(ranStr))
			{
				request.getSession().setAttribute("user", hr);
				response.sendRedirect("index.jsp");
				
			}
			else
			{
				request.setAttribute("error", "输入错误");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}

		if (action.equals("logout")) {
			request.getSession().removeAttribute("user");
			response.sendRedirect("index.jsp");
		}

		if (action.equals("register")) {
			
			String username1 = request.getParameter("username");
			User test = userDao.getByName(username1);
			if (test == null) {

				String password1 = request.getParameter("password");
				String email = request.getParameter("email");
			    String ishr=request.getParameter("ishr");
			    int i=0;
			    if(ishr.equals("employer"))
			    {
			    	i=1;
			    }
			    User user=new User(username1, password1, email, i);
			    userDao.add(user);
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("isSameName", "存在该用户");
				request.getRequestDispatcher("register.jsp")
				.forward(request, response);
			}

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

	

}
