package org.job_portal.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import org.job_portal.model.Application;
import org.job_portal.model.Approval;
import org.job_portal.model.Jobs;
import org.job_portal.model.Management;
import org.job_portal.model.User;

@Repository("userRepo")
public class userRepoImpl implements userRepo {
	@Autowired
	JdbcTemplate template;
	List<User> list;
	List<Jobs> jlist;
	List<Application> alist;
	List<Management> mlist;
	List<Approval> aplist;

	public boolean isAddNewUser(User user) {
		int val = template.update("insert into user values('0',?,?,?,?,?,?)", (PreparedStatement ps) -> {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getContact());
			ps.setString(5, user.getRole());
			ps.setString(6, user.getDate());
		});
		return val > 0;
	}

	@Override
	public List<User> getAllUser() {
		list = template.query("select * from user", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
			}

		});
		return list;
	}

	@Override
	public boolean isAddNewJob(Jobs job) {
		int val = template.update("insert into Jobs values('0',?,?,?,?,?,?,?,?,?,?)", (PreparedStatement ps) -> {
			ps.setInt(1, job.getEmployer_id());
			ps.setString(2, job.getTitle());
			ps.setString(3, job.getCategory());
			ps.setString(4, job.getDescription());
			ps.setInt(5, job.getRequirement());
			ps.setString(6, job.getLocation());
			ps.setDouble(7, job.getSalary());
			ps.setString(8, job.getJob_type());
			ps.setString(9, job.getStatus());
			ps.setString(10, job.getDate());
		});
		return val > 0;
	}

	@Override
	public List<Jobs> getAllJobs() {
		jlist = template.query("select * from Jobs", new RowMapper<Jobs>() {

			@Override
			public Jobs mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Jobs(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getString(9), rs.getString(10),
						rs.getString(11));
			}

		});
		return jlist;
	}

	@Override
	public boolean isAddNewApplication(Application application) {
		int val = template.update("insert into applications values('0',?,?,?,?)", (PreparedStatement ps) -> {
			ps.setInt(1, application.getJob_id());
			ps.setInt(2, application.getSeeker_id());
			ps.setString(3, application.getDate());
			ps.setString(4, application.getStatus());
		});
		return val > 0;
	}

	@Override
	public List<Application> getAllApplications() {
		alist = template.query("select * from applications", new RowMapper<Application>() {

			@Override
			public Application mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Application(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
			}

		});
		return alist;
	}

	@Override
	public boolean isAddNewManagement(Management management) {
		int val=template.update("insert into user_management values(?,?,?,?)",(PreparedStatement ps)->{
			ps.setInt(1,management.getAdmin_id());
			ps.setInt(2, management.getUser_id());
			ps.setString(3, management.getAction());
			ps.setString(4, management.getDate());
		});
		return val>0;
	}

	@Override
	public List<Management> getAllManagemenet() {
		mlist=template.query("select * from user_management ",new RowMapper<Management>() {

			@Override
			public Management mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Management(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
			}
			
		});
		return mlist;
	}

	@Override
	public boolean isJobApproval(Approval approval) {
		int val=template.update("insert into job_approval values(?,?,?,?)",(PreparedStatement ps)->{
			ps.setInt(1,approval.getAdmin_id());
			ps.setInt(2, approval.getJob_id());
			ps.setString(3, approval.getAction());
			ps.setString(4, approval.getDate());
		});
		return val>0;
	}

	@Override
	public List<Approval> getAllApproval() {
		aplist=template.query("select * from job_approval ",new RowMapper<Approval>() {

			@Override
			public Approval mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Approval(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
			}
			
		});
		return aplist ;
	}
}
