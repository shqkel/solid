package com.sh.app.bank1;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 1번 1_000_000원 계좌에서 100_000원 출금하는 예제
 * - BankApp이 실행, 도메인, 서비스등 모든 책임을 가지고 있다. -> SRP위반
 */
@AllArgsConstructor
@ToString
public class BankApp {
    private Long id;
    private BigDecimal balance;

    public void deposit(BigDecimal money) {
        this.balance = balance.add(money);
    }
    public void withdraw(BigDecimal money) {
        this.balance = balance.subtract(money);
        System.out.println(this); // BankApp(id=1, balance=900000)
    }
    
    public static void main(String[] args) {
        BankApp bankApp = new BankApp(1L, new BigDecimal(1_000_000));
        bankApp.withdraw(new BigDecimal(100_000));
    }
}
