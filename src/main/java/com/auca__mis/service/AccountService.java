package com.auca__mis.service;



import com.auca__mis.model.Account;

import java.util.List;

public interface AccountService {
    public boolean createAccount(Account account);
    public List<Account> accountList();
    public String login(String email, String password);
}
