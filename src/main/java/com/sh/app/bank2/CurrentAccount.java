package com.sh.app.bank2;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 자유로운 입출금 계좌
 */
@AllArgsConstructor
@ToString
public class CurrentAccount {
    private Long id;
    private BigDecimal balance;

    public void deposit(BigDecimal money) {
        this.balance = balance.add(money);
    }
    public void withdraw(BigDecimal money) {
        this.balance = balance.subtract(money);
        System.out.println(this); // BankApp(id=1, balance=900000)
    }
}
