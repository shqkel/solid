package com.sh.app.bank4;

import java.math.BigDecimal;

/**
 * <pre>
 * LSP를 만족하는 설계
 * - 모든 WithdrawableAccout의 자식클래스(CurrentAccount, SavingsAccount)는 deposit/withdraw기능을 수행한다.
 * - 출금서비스와 입금서비스 역시 분리하고, 의존주입의 타입을 달리 하였다.
 *  - BankWithrawableService#account: WithdrawableAccount
 *  - BankDepositableService#account: Account
 * </pre>
 */
public class BankApp {

    public static void main(String[] args) {
        BankWithrawableService bankWithrawableService;
        BankDepositableService bankDepositableService;

        WithdrawableAccount account1 = new CurrentAccount(1L, BigDecimal.valueOf(100_000));
        bankWithrawableService = new BankWithrawableService(account1);
        bankWithrawableService.withdraw(BigDecimal.valueOf(10_000));

        WithdrawableAccount account2 = new SavingsAccount(2L, BigDecimal.valueOf(100_000));
        bankWithrawableService = new BankWithrawableService(account2);
        bankWithrawableService.withdraw(BigDecimal.valueOf(10_000));

        Account account3 = new FixedTermDepositAccount(3L, BigDecimal.valueOf(100_000));
        bankDepositableService = new BankDepositableService(account3);
        bankDepositableService.deposit(BigDecimal.valueOf(10_000));
    }

}
