package com.myfuture.login.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("user_profile")
public class UserProfile {
	@Column("user_name")
	private String userName;
	
	@Column("first_name")
	private String firstName;
	@Column("last_name")
	private String lastName;
	@Column("living_area")
	private String livingArea;
//	private String email;
	@Column("car_brand")
	private String carBrand;
	@Column("car_model")
	private String carModel;
	@PrimaryKey("phone_number")
	private String phoneNumber;

}
