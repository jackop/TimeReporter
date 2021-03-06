package com.xing.timereporter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.xing.timereporter.model.User;
import com.xing.timereporter.model.UserPrincipal;
import com.xing.timereporter.repository.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepo userRepo;

	@Autowired
	public UserDetailsServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		System.out.println("XING:finding:username: " + username);
		User user = userRepo.findByUsername(username);
		System.out.println("XING:finding:user: " + user);
		System.out.println("XING:finding:id: " + user.getId());
		return new UserPrincipal(user);
	}
}
