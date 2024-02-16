# SOLID
객체지향 설계 원칙

<details>
<summary>목차</summary>

- [SOLID의 5가지 원칙](#solid의-5가지-원칙)
- [bank예제](#bank예제)
	- [@com.sh.app.bank1](#comshappbank1)
	- [@com.sh.app.bank2](#comshappbank2)
	- [@com.sh.app.bank3](#comshappbank3)
	- [@com.sh.app.bank4](#comshappbank4)
</details>



## SOLID의 5가지 원칙
- Single Responsibility Principle
- Open-closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle

## bank예제
특정계좌에서 출금하는 예제를 통해 SOLID 원칙을 학습한다.

###### [@com.sh.app.bank1](https://github.com/shqkel/solid/tree/master/src/main/java/com/sh/app/bank1)
![](https://d.pr/i/fm32V5+)

⚠️*BankApp이 실행, 도메인, 서비스등 모든 책임을 가지고 있다.* **SRP위반**


###### [@com.sh.app.bank2](https://github.com/shqkel/solid/tree/master/src/main/java/com/sh/app/bank2)
SRP를 만족하는 설계
- BankApp : 프로그램 실행 책임
- BankService : 계좌 입/출금 기능 수행 책임 (응용 레이어)
- CurrentAccount : 계좌정보 관리 (도메인 레이어)

![](https://d.pr/i/1cmq3A+)

⚠️*여기서 입출금계좌(CurrentAccount) 외에 적금계좌(SavingAccount)도 추가적으로 관리해야 한다면?*
- *BankService#currentAccount:CurrentAccount는 수정이 불가피하다.* **OCP위반** 


###### [@com.sh.app.bank3](https://github.com/shqkel/solid/tree/master/src/main/java/com/sh/app/bank3)
 OCP, DIP를 만족하는 설계
- OCP : BankService는 Account에 의존하므로 특정계좌가 추가되어도 변경되지 않는다.
- DIP : BankService는 구현체가 아닌 추상화 레이어에 Account에 의존하고 있다.

![](https://d.pr/i/QmiSJs+)

⚠️*여기서 자유예금계좌(FixedTermDepositAccount)가 추가된다면?*
- *자유예금계좌의 출금은 불가능해야 하므로, FixedTermDepositAccount#withdraw는 예외를 던져야 한다.*
- *부모클래스 Account의 모든 자식클래스는 deposit/withdraw 수행이 가능해야 하지만 그렇지 않다.* **LSP위반**

###### [@com.sh.app.bank4](https://github.com/shqkel/solid/tree/master/src/main/java/com/sh/app/bank4)
LSP를 만족하는 설계
- 모든 WithdrawableAccout의 자식클래스(CurrentAccount, SavingsAccount)는 deposit/withdraw기능을 수행한다.
- 출금서비스와 입금서비스 역시 분리하고, 의존주입의 타입을 달리 하였다.
  - `BankWithrawableService#account: WithdrawableAccount`
  - `BankDepositableService#account: Account`

![](https://d.pr/i/wRjEmH+)
