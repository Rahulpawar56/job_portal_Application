package org.job_portal.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.job_portal.model.Application;
import org.job_portal.model.Approval;
import org.job_portal.model.Jobs;
import org.job_portal.model.Management;
import org.job_portal.model.User;
import org.job_portal.service.userServiceImpl;

@RestController
public class Job_Portal_Application {
	@Autowired
	userServiceImpl userService;
	List<User> list;
	List<Jobs> jlist;
	List<Application> alist;
	List<Management> mlist;
	List<Approval> aplist;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		boolean b = userService.isAddNewUser(user);
		return b ? "User Added" : "User Not Added";
	}
	
	@GetMapping("/viewAllUsers")
	public List<User> getAllUser(){
		list=userService.getAllUser();
		return list;
	}
	
	@PostMapping("addJob")
	public String addJob(@RequestBody Jobs job) {
		boolean b = userService.isAddNewJob(job);
		return b ? "New Job Added" : "Job Not Added";
	}
	
	@GetMapping("/viewAllJobs")
	public List<Jobs> getAllJobs(){
		jlist=userService.getAllJobs();
		return jlist;
	}
	
	@PostMapping("/addApplications")
	public String addApplications(@RequestBody Application application) {
		boolean b = userService.isAddNewApplication(application);
		return b ? "New Aplication Added" : "Job Application Added";
	}
	
	@GetMapping("/viewAllApplications")
	public List<Application> getAllApplications(){
		alist=userService.getAllApplications();
		return alist;
	}
	
	@PostMapping("/addManagement")
	public String isAddManagement(@RequestBody Management management) {
		boolean b=userService.isAddNewManagement(management);
		return b ? "Add new Management ":"not add Management";
	}
	
	@GetMapping("/viewAllManagement")
	public List<Management> getAllManagemenet(){
		mlist=userService.getAllManagemenet();
		return mlist;
	}
	
	@PostMapping("/addJobApproval")
	public String jobApproval(@RequestBody Approval approval) {
		boolean b=userService.isJobApproval(approval);
		return b ? "Approved Succesfully": "Not Approved";
	}
	
	@GetMapping("/viewAllApproval")
	public List<Approval> getAllApproval(){
		aplist=userService.getAllApproval();
		return aplist;
	}
}
