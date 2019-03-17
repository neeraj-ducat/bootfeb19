package com.ducat.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ducat.entities.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate template;
	
	//Query to save a user
	public static final String save_query="insert into UsersMaster (name,mailId,password) values(?,?,?)";
	//Query to fina a user using mailId
	public static final String findByMailId_query="select * from UsersMaster where mailId=?";

	//Method to save a User
	public void save(User user) throws Exception
	{
		template.update(save_query, user.getName(),user.getMailId(),user.getPassword());
	}
	
	//Method to find users using mailId
		public List findByMailId(String mailId) throws Exception
		{
			return template.query(findByMailId_query, new String[] {mailId}, new UserMapper());
		}
		
		//Inner class to map UsersMaster records to the User object
		public class UserMapper implements RowMapper<User>
		{

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setMailId(rs.getString(3));
				user.setPassword(rs.getString(4));
				return user;
			}
			
		}
}
