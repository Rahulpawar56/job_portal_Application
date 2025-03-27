package org.job_portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Management {
	private int admin_id;
	private int user_id;
	private String action;
	private String date;
}
