package useraccount.services.impl;

import useraccount.services.AccountService;
import framework.annotations.Component;

@Component
public class AccountServiceImpl implements AccountService {

	@Override
	public Long getAccountNumber(String userName) {
		return 12345689L;
	}
}
