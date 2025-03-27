package org.job_portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Approval {
	private int admin_id;
	private int job_id;
	private String action;
	private String date;
}
