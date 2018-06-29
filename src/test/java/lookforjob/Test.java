package lookforjob;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.JobDao;
import dao.UserDao;
import entity.Job;
import entity.User;

public class Test {
    
	@org.junit.Test
	public void test()
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
	    JobDao jobDao=(JobDao) context.getBean("jobDao");
	    Job job=new Job("11", 111, "11", "11", "11", "11");
	    jobDao.add(job);
	    ArrayList<Job> list=jobDao.getTenList();
        for(Job j:list)
        {
        	System.out.println(j.getId());
        }

	    
	}
	
}
