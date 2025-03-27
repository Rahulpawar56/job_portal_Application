package org.job_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.job_portal.model.Application;
import org.job_portal.model.Approval;
import org.job_portal.model.Jobs;
import org.job_portal.model.Management;
import org.job_portal.model.User;
import org.job_portal.repository.userRepoImpl;

@Service("userService")
public class userServiceImpl implements userService {

	@Autowired
	userRepoImpl userRepo;

	@Override
	public boolean isAddNewUser(User user) {

		return userRepo.isAddNewUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.getAllUser();
	}

	@Override
	public boolean isAddNewJob(Jobs job) {
		return userRepo.isAddNewJob(job);
	}

	@Override
	public List<Jobs> getAllJobs() {
		return userRepo.getAllJobs();
	}

	@Override
	public boolean isAddNewApplication(Application application) {
		return userRepo.isAddNewApplication(application);
	}

	@Override
	public List<Application> getAllApplications() {
		return userRepo.getAllApplications();
	}

	@Override
	public boolean isAddNewManagement(Management management) {
		return userRepo.isAddNewManagement(management);
	}

	@Override
	public List<Management> getAllManagemenet() {
		return userRepo.getAllManagemenet();
	}

	@Override
	public boolean isJobApproval(Approval approval) {
		
		return userRepo.isJobApproval(approval) ;
	}

	@Override
	public List<Approval> getAllApproval() {

		return userRepo.getAllApproval();
	}

}
