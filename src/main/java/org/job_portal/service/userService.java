package org.job_portal.service;

import java.util.List;

import org.job_portal.model.Application;
import org.job_portal.model.Approval;
import org.job_portal.model.Jobs;
import org.job_portal.model.Management;
import org.job_portal.model.User;

public interface userService {
	public boolean isAddNewUser(User user);
	
	public List<User> getAllUser();
	
	public boolean isAddNewJob(Jobs job);
	
	public List<Jobs> getAllJobs();
	
	public boolean isAddNewApplication(Application application);
	
	public List<Application>getAllApplications();
	
	public boolean isAddNewManagement(Management management);
	
	public List<Management> getAllManagemenet();
	
	public boolean isJobApproval(Approval approval) ;
	
	public List<Approval> getAllApproval();
}
