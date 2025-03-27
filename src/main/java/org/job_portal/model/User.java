package org.job_portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int user_id;
	private String name;
	private String email;
	private String password;
	private String contact;
	private String role;
	private String date;
}
