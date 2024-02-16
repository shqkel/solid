package com.sh.app.bank4;

import lombok.ToString;

import java.math.BigDecimal;

/**
 * <pre>
 * 정기예금계좌
 * - 정해진 기간동안 예금으로 만료이전에 출금이 불가하다.
 * </pre>
 */
@ToString(callSuper = true)
public class FixedTermDepositAccount extends Account {
    public FixedTermDepositAccount(long id, BigDecimal balance) {
        super(id, balance);
    }

}
