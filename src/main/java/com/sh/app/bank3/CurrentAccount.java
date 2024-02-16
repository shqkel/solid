package com.sh.app.bank3;

import lombok.ToString;

import java.math.BigDecimal;

/**
 * 자유로운 입출금 계좌
 */
@ToString(callSuper = true)
public class CurrentAccount extends Account {
    public CurrentAccount(Long id, BigDecimal balance) {
        super(id, balance);
    }
}
