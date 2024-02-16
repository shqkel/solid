package com.sh.app.bank3;

import lombok.ToString;

import java.math.BigDecimal;

/**
 * 적금 계좌
 */
@ToString(callSuper = true)
public class SavingsAccount extends Account {
    public SavingsAccount(Long id, BigDecimal balance) {
        super(id, balance);
    }
}
