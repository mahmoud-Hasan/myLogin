package com.myfuture.login.Repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.myfuture.login.model.UserProfile;

@Repository
public interface UserProfileRepo extends CassandraRepository<UserProfile,String>{
	
	

}
