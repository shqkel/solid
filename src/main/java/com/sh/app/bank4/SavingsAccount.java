package com.sh.app.bank4;

import lombok.ToString;

import java.math.BigDecimal;

/**
 * 적금 계좌
 */
@ToString(callSuper = true)
public class SavingsAccount extends WithdrawableAccount {
    public SavingsAccount(Long id, BigDecimal balance) {
        super(id, balance);
    }
}
