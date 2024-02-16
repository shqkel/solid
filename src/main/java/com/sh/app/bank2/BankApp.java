package com.sh.app.bank2;

import java.math.BigDecimal;

/**
 * <pre>
 * SRP를 만족하는 설계
 * - BankApp : 프로그램 실행 책임
 * - BankService : 계좌 입/출금 기능 수행 책임 (응용 레이어)
 * - CurrentAccount : 계좌정보 관리 (도메인 레이어)
 *
 * 여기서 입출금계좌(CurrentAccount) 외에 적금계좌(SavingAccount)도 추가적으로 관리해야 한다면?
 * - BankService#currentAccount는 수정이 불가피하다. OCP위반
 * - OCP란? 확장이 가능(open)하면서, 기존코드가 변경되어서는 안된다(close)
 * </pre>
 * 
 */
public class BankApp {

    public static void main(String[] args) {
        BankService bankService = new BankService(new CurrentAccount(1L, BigDecimal.valueOf(100_000)));
        bankService.withdraw(BigDecimal.valueOf(10_000));
    }

}
