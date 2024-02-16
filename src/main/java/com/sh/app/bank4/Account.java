package com.sh.app.bank4;

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
    protected Long id;
    protected BigDecimal balance;

    public void deposit(BigDecimal money) {
        this.balance = balance.add(money);
        System.out.println(this);
    }
}
