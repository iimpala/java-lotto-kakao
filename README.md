# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## rule
- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
  - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- else를 사용하지 마라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 ArrayList를 사용한다.
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 규칙 8: 일급 콜렉션을 쓴다.


## Todo
- [x] 시스템은 로또 구매 금액을 입력 받는다
  - [x] 구매 금액은 10만원 이하여야 한다
  - [x] 구매 금액은 1000의 배수여야 한다
  - [x] 구매 금액은 양의 정수만 허용한다
- [x] 시스템은 구매 금액에 상응하는 개수의 로또 번호를 만들어준다
  - [x] 로또 번호는 1 ~ 45 사이의 중복되지 않는 6개의 수로 이루어져 있다(Ticket)
- [x] 시스템은 로또 당첨 번호를 입력 받는다(WinningNumber)
  - [x] 당첨 번호는 1 ~ 45 사이의 중복되지 않는 6개의 수와 보너스볼 1개로 이루어져 있다.
  - [x] 보너스 볼은 당첨 번호와 중복되지 않는 1 ~ 45 사이의 수 1개이다.
- [x] 시스템은 사용자가 구매한 로또 번호에 대해 당첨 여부를 판단한다.
  - [x] 5등 당첨 규칙 : 사용자의 로또 번호와 당첨 번호가 3개 일치
  - [x] 4등 당첨 규칙 : 사용자의 로또 번호와 당첨 번호가 4개 일치
  - [x] 3등 당첨 규칙 : 사용자의 로또 번호와 당첨 번호가 5개 일치
  - [x] 2등 당첨 규칙 : 사용자의 로또 번호와 당첨 번호가 5개 일치 + 보너스 볼과 일치
  - [x] 1등 당첨 규칙 : 사용자의 로또 번호와 당첨 번호가 6개 일치
- [x] 시스템은 당첨된 로또에 대한 통계와 수익률을 집계한다
  - [x] 5등 당첨금은 5000원이다
  - [x] 4등 당첨금은 50000원이다
  - [x] 3등 당첨금은 1500000원이다
  - [x] 2등 당첨금은 30000000원이다
  - [x] 1등 당첨금은 2000000000원이다
  - [x] 수익률은 (당첨금 총합) / (구매 금액) 이다.


