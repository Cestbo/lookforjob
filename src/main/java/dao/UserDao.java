package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



import entity.User;


public class UserDao {
	@Resource(name="jdbcTemplate")
    private JdbcTemplate jdbc;
    
	public void add(User hr) {
		String sql="insert into hr values(?,?,?,?)";
		jdbc.update(sql, hr.getName(),hr.getPassword(),hr.getEmail(),hr.getIshr());
		
	}
	
	public User getByName(String name)
	{
		User hr=null;
		String sql="select * from hr where name=?";
		try {
			hr=jdbc.queryForObject(sql, 
					new RowMapper<User>(){

						@Override
						public User mapRow(ResultSet rs, int rowNum) throws SQLException  {
							// TODO Auto-generated method stub
							User hr=new User();
							hr.setName(rs.getString("name"));
							hr.setPassword(rs.getString("password"));
							hr.setEmail(rs.getString("email"));
							hr.setIshr(rs.getInt("ishr"));
							return hr;
						}
				
			}, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hr;
	}
	
}
