package com.nikhilrana.aspectProgramming.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {
    @Override
    public void addAccount() {
        System.out.println("Creating the Account from Membership Dao");
    }

    @Override
    public int addMember() {
        return 1;
    }
}
