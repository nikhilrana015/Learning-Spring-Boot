package com.nikhilrana.aspectProgramming.Dao;


import com.nikhilrana.aspectProgramming.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Override
    public void addAccount(Account account, boolean hasPremium) {
        System.out.println("Creating the Account from Account Dao");
        System.out.println(account.toString());
        System.out.println("Has Premium: " + hasPremium);
    }

    @Override
    public void deleteAccount() {
        System.out.println("Account has been deleted");
    }
}
