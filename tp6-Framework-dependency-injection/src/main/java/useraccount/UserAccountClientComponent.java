package useraccount;


import framework.annotations.Autowired;
import framework.annotations.Component;
import framework.annotations.Qualifier;
import useraccount.services.AccountService;
import useraccount.services.UserService;

/**
 * Client class, havin userService and accountService expected to initialized by
 * CustomInjector.java
 */
@Component
public class UserAccountClientComponent {

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier(value = "accountServiceImpl")
	private AccountService accountService;

	public void displayUserAccount() {
		String username = userService.getUserName();
		Long accountNumber = accountService.getAccountNumber(username);
		System.out.println("\n\tUser Name: " + username + "\n\tAccount Number: " + accountNumber + "\n");
	}
}
