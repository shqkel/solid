package com.sh.app.bank3;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class BankService {
    final Account account;

    public void withdraw(BigDecimal money) {
        account.withdraw(money);
    }
}
