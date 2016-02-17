package com.learning;

import org.springframework.stereotype.Service;

@Service
public interface LoginDao {
	
	public void updateLoginDetails(String loginDetails) throws Exception;

}
