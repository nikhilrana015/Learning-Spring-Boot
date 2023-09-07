package com.nikhilrana.aspectProgramming.Dao;


import com.nikhilrana.aspectProgramming.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class AccountDaoImpl implements AccountDao {

    private String name;

    private String code;

    @Override
    public void addAccount(Account account, boolean hasPremium) {
        System.out.println("Creating the Account from Account Dao");
        //System.out.println(account.toString());
        //System.out.println("Has Premium: " + hasPremium);
    }

    @Override
    public void deleteAccount() {
        System.out.println("Account has been deleted");
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(true);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire) {
            throw new RuntimeException("Something is fishy");
        }

        Account account1 = new Account("anjali", "rana", "anjali@xyz.com");
        Account account2 = new Account("Naman", "rana", "naman@xyz.com");
        Account account3 = new Account("Raman", "rana", "raman@xyz.com");

        List<Account>list = new ArrayList<>();

        list.add(account1);
        list.add(account2);
        list.add(account3);

        return list;
    }
}
