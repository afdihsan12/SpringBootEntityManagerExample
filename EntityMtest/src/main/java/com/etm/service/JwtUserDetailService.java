package com.etm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.etm.model.Students;


@Service
public class JwtUserDetailService implements UserDetailsService {

	@Autowired
	ServiceStudent serviceStudent;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Students user = serviceStudent.findByname(username);
		if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getNama(), user.getAlamat(),
                new ArrayList<>());
	}

	
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		Students user = serviceStudent.findByname(username);
//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",new ArrayList<>());
//		}
//		return new User(user.getNama(), user.getAlamat(),
//                new ArrayList<>());
//	}	
}
