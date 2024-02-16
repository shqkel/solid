package com.sh.app.bank2;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class BankService {
    final CurrentAccount currentAccount;

    public void withdraw(BigDecimal money) {
        currentAccount.withdraw(money);
    }
}
