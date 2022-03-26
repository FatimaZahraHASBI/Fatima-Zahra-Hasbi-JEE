package useraccount.services.impl;

import useraccount.services.UserService;
import framework.annotations.Component;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public String getUserName() {
		return "username";
	}
}
