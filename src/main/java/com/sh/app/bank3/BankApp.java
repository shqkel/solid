package com.sh.app.bank3;

import java.math.BigDecimal;

/**
 * <pre>
 * OCP, DIP를 만족하는 설계
 * - OCP : BankService는 Account에 의존하므로 특정계좌가 추가되어도 변경되지 않는다.
 * - DIP : BankService는 구현체가 아닌 추상화 레이어에 Account에 의존하고 있다.
 * - DIP란? 변화하기 쉬운 것 또는 자주 변화하는 것보다는 변화하기 어려운 것, 거의 변화가 없는 것에 의존해야한다.
 *
 * 여기서 자유예금계좌(FixedTermDepositAccount)가 추가된다면?
 * - 자유예금계좌의 출금은 불가능해야 하므로, FixedTermDepositAccount#withdraw는 예외를 던져야 한다.
 * - 부모클래스 Account의 모든 자식클래스는 deposit/withdraw 수행이 가능해야 하지만 그렇지 않으므로, LSP위반!
 * </pre>
 * 
 */
public class BankApp {

    public static void main(String[] args) {
        Account account1 = new CurrentAccount(1L, BigDecimal.valueOf(100_000));
        BankService bankService = new BankService(account1);
        bankService.withdraw(BigDecimal.valueOf(10_000));

        Account account2 = new SavingsAccount(2L, BigDecimal.valueOf(100_000));
        bankService = new BankService(account2);
        bankService.withdraw(BigDecimal.valueOf(10_000));

        Account account3 = new FixedTermDepositAccount(3L, BigDecimal.valueOf(100_000));
        bankService = new BankService(account3);
        bankService.withdraw(BigDecimal.valueOf(10_000));
    }

}
