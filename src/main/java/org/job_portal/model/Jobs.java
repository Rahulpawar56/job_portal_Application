package org.job_portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jobs {
	private int job_id;
	private int employer_id;
	private String title;
	private String category;
	private String description;
	private int requirement;
	private String location;
	private double salary;
	private String job_type;
	private String status;
	private String date;
}
