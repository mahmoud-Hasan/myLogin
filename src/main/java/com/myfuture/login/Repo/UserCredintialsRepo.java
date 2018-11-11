package com.myfuture.login.Repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.myfuture.login.model.UserCredentials;

@Repository
public interface UserCredintialsRepo  extends CassandraRepository<UserCredentials, String>{

	UserCredentials findByPhoneNumber(String phoneNumber);

}
