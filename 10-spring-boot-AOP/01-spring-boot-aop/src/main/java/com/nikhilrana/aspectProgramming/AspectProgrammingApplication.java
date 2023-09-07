package com.nikhilrana.aspectProgramming;

import com.nikhilrana.aspectProgramming.Dao.AccountDao;
import com.nikhilrana.aspectProgramming.Dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectProgrammingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao) {

		return runner -> {
			demoBeforeAdvice(accountDao, membershipDao);
		};
	}

	private void demoBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {

		Account account = new Account("Nikhil", "Rana", "nikhil15.xyz@gmail.com");
		accountDao.addAccount(account, false);
		accountDao.deleteAccount();

		System.out.println("###################################################");
		membershipDao.addAccount();
		System.out.println(membershipDao.addMember());

		//System.out.println(membershipDao.addMember());
		//membershipDao.addAccount();
	}

}
