package com.sh.app.bank3;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 공통 계좌
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {
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
