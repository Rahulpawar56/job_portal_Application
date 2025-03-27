package org.job_portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
	private int application_id;
	private int job_id;
	private int seeker_id;
	private String date;
	private String status;
	
}
