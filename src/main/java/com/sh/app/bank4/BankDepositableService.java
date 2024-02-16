package com.sh.app.bank4;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class BankDepositableService {
    final Account account;

    public void deposit(BigDecimal money) {
        account.deposit(money);
    }
}
