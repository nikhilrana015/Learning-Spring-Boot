package com.nikhilrana.aspectProgramming;

import com.nikhilrana.aspectProgramming.Dao.AccountDao;
import com.nikhilrana.aspectProgramming.Dao.MembershipDao;
import com.nikhilrana.aspectProgramming.Service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AspectProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectProgrammingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao,
											   MembershipDao membershipDao,
											   TrafficFortuneService trafficFortuneService
	) {

		return runner -> {
			//demoBeforeAdvice(accountDao, membershipDao);
			//demoAfterReturningAdvice(accountDao);
			//demoAfterThrowingAdvice(accountDao);
			//demoAfterAdvice(accountDao);
			//demoAroundAdvice(trafficFortuneService);
			//demoAroundAdviceHandleException(trafficFortuneService);
			demoAroundAdviceThrowException(trafficFortuneService);
		};
	}

	private void demoAroundAdviceThrowException(TrafficFortuneService trafficFortuneService) {
		boolean tripWire = true;

		String fortune = trafficFortuneService.getFortune(tripWire);
		System.out.println("=>>>>>> From main: AdviceThrowException Demo");
		System.out.println("Forune is: " + fortune);
	}

	private void demoAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {

		boolean tripWire = true;

		String fortune = trafficFortuneService.getFortune(tripWire);
		System.out.println("=>>>>>> From main: AdviceHandleException Demo");
		System.out.println("Forune is: " + fortune);
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {

		String fortune = trafficFortuneService.getFortune();
		System.out.println("=>>>>>> From main: Advice Demo");
		System.out.println("Forune is: " + fortune);
	}

	private void demoAfterAdvice(AccountDao accountDao) {

		List<Account>accountList = null;

		try {
			boolean tripWire = false;
			accountList = accountDao.findAccounts(tripWire);
			System.out.println("=>>>>>> From main, accountList is: " + accountList);

		} catch (Exception exception) {
			System.out.println("=>>>>> From main, Exception is caught. " + exception);
		}
	}


	private void demoAfterThrowingAdvice(AccountDao accountDao) {

		List<Account>accountList = null;

		try {
			boolean tripWire = true;
			accountList = accountDao.findAccounts(tripWire);

		} catch (Exception exception) {
			System.out.println("Exception is caught. " + exception);
		}
	}

	private void demoAfterReturningAdvice(AccountDao accountDao) {
		List<Account>accountList = accountDao.findAccounts();
		System.out.println(accountList);
	}

	private void demoBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {

		Account account = new Account("Nikhil", "Rana", "nikhil15.xyz@gmail.com");
		accountDao.addAccount(account, false);
		System.out.println("###################################################");

		accountDao.setName("Nikhil Rana");
		accountDao.setCode("12857");

		System.out.println("###################################################");
		System.out.println(accountDao.getName());
		System.out.println(accountDao.getCode());

		System.out.println("###################################################");
		membershipDao.addAccount();

		System.out.println("###################################################");
		System.out.println(membershipDao.addMember());

		//System.out.println(membershipDao.addMember());
		//membershipDao.addAccount();
	}

}
