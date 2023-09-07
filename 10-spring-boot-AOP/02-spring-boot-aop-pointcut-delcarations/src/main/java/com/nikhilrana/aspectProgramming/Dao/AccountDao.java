package com.nikhilrana.aspectProgramming.Dao;

import com.nikhilrana.aspectProgramming.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountDao {
    void addAccount(Account account, boolean hasPremium);

    void deleteAccount();

    void setName(String name);

    String getName();

    void setCode(String code);

    String getCode();

    public List<Account>findAccounts();

    public List<Account>findAccounts(boolean tripWire);
}
