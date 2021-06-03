# ProjectB  (도서관리 프로젝트)


## 진행중인 것 👉
- [ ]  코딩 컨벤션(코딩 작성 규칙 및 자료구조 방향 설정)
- [ ]  구현

## 해야할 것 👆
- [ ]  보수
- [ ]  ppt제작

## 완료한 것 👌
- [x]  각 메뉴 시나리오 작성
- [x]  프로젝트 주제선정
- [x]  팀 분할
- [x]  github 저장소 생성 및 연결
- [x]  업무시간 협의 : 자유 (평일 수업시간 권장)
- [x]  포지션 분할
- [x]  코딩 컨벤션(코딩 작성 규칙 및 자료구조 방향 설정)
- [ ]  
## 코드 컨벤션🔥

- jdk 라이브러리 버전 1.8로 코딩
- Scanner 참조변수 sc로 통일

```java
Scanner sc = new Scanner(System.in);

```

- 한줄 코드라 블록 생략 가능해도 { } 반드시 쓰기

```java
if(i < 0) { return;}  // 권장! ⭕
if(i < 0)   return;   // 지양! ❌
```
- 프롬포트 >>
```java
final String PROMPT=">>";
```
- 메뉴출력시 [MENU]
```java
final String MENU="[MENU]";
```
- 메서드 /클래스 종료 { } 끝에 표시
```java
	}//main method종료
} // main class종료
```
