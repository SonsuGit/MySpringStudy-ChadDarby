package com.suha.aopdemo;

import com.suha.aopdemo.dao.AccountDAO;
import com.suha.aopdemo.dao.AccountDAOImpl;
import com.suha.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		return runner ->{

			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}
}
