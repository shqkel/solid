package com.sh.app.bank4;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class BankWithrawableService {
    final WithdrawableAccount account;

    public void withdraw(BigDecimal money) {
        account.withdraw(money);
    }
}
