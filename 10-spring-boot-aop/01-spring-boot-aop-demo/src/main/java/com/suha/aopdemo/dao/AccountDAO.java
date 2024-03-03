package com.suha.aopdemo.dao;

import com.suha.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
