package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.JobDao;
import entity.Job;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class Jobservlet
 */
@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean1.xml");
		JobDao jobDao=(JobDao)context.getBean("jobDao");
		if(action.equals("add"))
		{
			String name=request.getParameter("name");
			String company=request.getParameter("company");
			String city=request.getParameter("city");
			String salary=request.getParameter("salary");
			String description=request.getParameter("description");
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String time=df.format(date);
			Job job=new Job(name, Integer.valueOf(salary), city, company, description, time);
			jobDao.add(job);
			response.sendRedirect("index.jsp");
		}
		if(action.equals("select"))
		{
			ArrayList<Job> list=new ArrayList<Job>();
			list=jobDao.getTenList();
			JSONArray jArray=JSONArray.fromObject(list);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jArray.toString());
		}
		if(action.equals("detail"))
		{
			String id=request.getParameter("id");
			Job job=jobDao.getById(Integer.valueOf(id));
			request.setAttribute("job", job);
			request.getRequestDispatcher("detail.jsp")
			.forward(request, response);
		}
		if(action.equals("search"))
		{
			String keyword=request.getParameter("keyword");
			keyword=java.net.URLDecoder.decode(keyword,"UTF-8");
			ArrayList<Job> list=jobDao.getByKeyword(keyword);
			request.setAttribute("list", list);
			request.getRequestDispatcher("searchRs.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
