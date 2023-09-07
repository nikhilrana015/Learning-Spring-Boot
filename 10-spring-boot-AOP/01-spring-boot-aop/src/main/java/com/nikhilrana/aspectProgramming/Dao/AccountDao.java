package com.nikhilrana.aspectProgramming.Dao;

import com.nikhilrana.aspectProgramming.Account;
import org.springframework.stereotype.Component;

@Component
public interface AccountDao {
    void addAccount(Account account, boolean hasPremium);
    void deleteAccount();
}
