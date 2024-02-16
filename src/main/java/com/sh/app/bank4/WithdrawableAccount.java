package com.sh.app.bank4;

import lombok.ToString;

import java.math.BigDecimal;

/**
 * 출금 가능한 공통 계좌
 */
@ToString(callSuper = true)
public class WithdrawableAccount extends Account {

    public WithdrawableAccount(Long id, BigDecimal balance) {
        super(id, balance);
    }

    public void withdraw(BigDecimal money) {
        this.balance = balance.subtract(money);
        System.out.println(this); // BankApp(id=1, balance=900000)
    }
}
