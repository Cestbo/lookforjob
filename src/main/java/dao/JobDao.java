package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Job;

@Repository("jobDao")
public class JobDao {
	@Resource(name="jdbcTemplate")
    private JdbcTemplate jdbc;
	
	public void add(Job job)
	{
		String sql="insert into job values(?,?,?,?,?,?)";
		jdbc.update(sql, job.getName(),job.getSalary(),
				job.getCity(),job.getCompany(),job.getDescription(),job.getTime());
		
		  
	}
	
	public Job getById(int id)
	{
		Job job=null;
		String sql="select * from job where id=?";
		try {
			job=jdbc.queryForObject(sql, 
					new RowMapper<Job>(){

						@Override
						public Job mapRow(ResultSet rs, int rowNum) throws SQLException  {
							// TODO Auto-generated method stub
							Job hr=new Job();
							hr.setName(rs.getString("name"));
							hr.setCity(rs.getString("city"));
							hr.setId(rs.getInt("id"));
							hr.setSalary(rs.getInt("salary"));
							hr.setCompany(rs.getString("company"));
							hr.setDescription(rs.getString("description"));
							hr.setTime(rs.getString("time"));
							return hr;
						}
				
			}, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return job;
		
	}
	
	public ArrayList<Job> getByKeyword(String keyword)
	{
		ArrayList<Job> jobs=new ArrayList<Job>();
		String sql="select * from job where name like '%"+keyword+"%'";
		try {
			jobs=(ArrayList<Job>) jdbc.query(sql, 
					new RowMapper<Job>(){

						@Override
						public Job mapRow(ResultSet rs, int rowNum) throws SQLException  {
							// TODO Auto-generated method stub
							Job hr=new Job();
							hr.setName(rs.getString("name"));
							hr.setCity(rs.getString("city"));
							hr.setId(rs.getInt("id"));
							hr.setSalary(rs.getInt("salary"));
							hr.setCompany(rs.getString("company"));
							hr.setDescription(rs.getString("description"));
							hr.setTime(rs.getString("time"));
							return hr;
						}
				
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobs;
	}
	
	public ArrayList<Job> getTenList()
	{
		ArrayList<Job> jobs=new ArrayList<Job>();
		String sql="select top 10 * from job order by id desc";
		try {
			jobs=(ArrayList<Job>) jdbc.query(sql, 
					new RowMapper<Job>(){

						@Override
						public Job mapRow(ResultSet rs, int rowNum) throws SQLException  {
							// TODO Auto-generated method stub
							Job hr=new Job();
							hr.setName(rs.getString("name"));
							hr.setCity(rs.getString("city"));
							hr.setId(rs.getInt("id"));
							hr.setSalary(rs.getInt("salary"));
							hr.setCompany(rs.getString("company"));
							hr.setDescription(rs.getString("description"));
							hr.setTime(rs.getString("time"));
							return hr;
						}
				
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobs;
	}
	
}
