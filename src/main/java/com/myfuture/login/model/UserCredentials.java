package com.myfuture.login.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.myfuture.login.validator.ValidPhoneNumber;

import lombok.Data;

@Data
@Table("user_credintials")
public class UserCredentials {
	
	@PrimaryKey(value="phone_number")
	@NotNull
    @NotEmpty
    @ValidPhoneNumber
	private String phoneNumber;
	
	@NotNull
    @NotEmpty
	private String password;
	
	@Column("is_active")
	private boolean isActive;
	
	@Column("activation_code")
	private String activationCode;
	
	@Transient
	@NotNull
	@NotEmpty
	private String userName;
	
}
