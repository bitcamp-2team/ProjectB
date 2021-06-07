import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	/**공통 문구 / 예쁜디자인 있으면 변경해주세요~*/
	final static String MENU = "[MENU] "; //메뉴 앞에
	final static String PROMPT = ">> ";  //입력창 앞에 
	
	static UserPlay userPlay = new UserPlay();
	static BookPlay bookPlay = new BookPlay();
	
	public static void main(String[] args) { //초기화면 출력 
		beginningPage();
	} //main method(초기화면) 종료


	static void beginningPage() { //초기화면 출력
		do {
			System.out.println(MENU + "1.일반회원  2.사서  0.종료");
			System.out.print(PROMPT);
			String input = sc.next();
			switch(input) {
				case "1" : {				
					membersMenu(); //일반회원메뉴 출력 메소드 호출
					break;
				}
				case "2":{
					userPlay.managerLogin(); //사서 로그인 메소드 호출 //사서 로그인하고나면 managerMenu페이지로 가야 함
					break;      
				}
				case "0" : {
					System.out.println("프로그램이 종료됩니다.");
					sc.close();
					System.exit(0);
				}
				default : continue;
			}
		} while(true);		
	} //beginningPage(초기화면) 메소드 종료

	
/** 여기부터 일반회원메뉴 메소드 */
	static void membersMenu() { //일반회원메뉴 출력	
		do {	
			System.out.println(MENU + "1.회원가입  2.로그인  0.초기메뉴");
			System.out.print(PROMPT);
			String input = sc.next();
			switch(input) {
				case "1" : {
					userPlay.join(); //회원가입 메소드 호출 //회원가입하면 membersMenu페이지로 가야함
					break;
				}
				case "2" : {
					userPlay.logIn(); //로그인 메소드 호출 //로그인하면 LogInMenu페이지로 가야함
					break;
				}
				case "0" : {
					beginningPage(); //초기화면으로 돌아가기
				}
				default : continue;
			}
		} while(true);
	} //membersMenu(일반회원메뉴) 메소드 종료
	
	
	static void logInMenu() { //일반회원메뉴-로그인메뉴(로그인하면 이용할 수 있는 메뉴) 출력	
		do {	
			System.out.println(MENU + "1.도서 검색  2.마이페이지  0.로그아웃");
			System.out.print(PROMPT);
			String input = sc.next();
			switch(input) {
				case "1" : {
					bookPlay.searchMenu(); //도서검색 메소드 호출
					break;
				}
				case "2" : {
					myPage(); //마이페이지 출력 메소드 호출
					break;
				}
				case "0" : {
					userPlay.logOut(); //로그아웃 메소드 호출 //로그아웃하면 membersMenu페이지로 가야 함
					break;
				}
				default : continue;
			}
		} while(true);
	} //logInMenu(로그인메뉴)메소드 종료
	
	
	static void myPage() { //일반회원메뉴-로그인메뉴-마이페이지 출력	
		do {	
			System.out.println(MENU + "1.대여목록  2.회원탈퇴  0.이전 메뉴");
			System.out.print(PROMPT);
			String input = sc.next();
			switch(input) {
				case "1" : {
					userPlay.viewRentalBooks(); //대여목록보기 메소드 호출 
					break;
				}
				case "2" : {
					userPlay.withdrawal(); //회원탈퇴 메소드 호출 //회원탈퇴하고나면 membersMenu페이지로 가야 함
					break;
				}
				case "0" : {
					logInMenu(); //logInMenu(로그인메뉴) 메소드 호출
					break;
				}
				default : continue;
			}
		} while(true);
	} //myPage(마이페이지)메소드 종료
/** 여기까지 일반회원메뉴 메소드 */


/** 여기부터 사서메뉴 메소드 */	
	static void managerMenu() { //사서메뉴 출력	
		do {	
			System.out.println(MENU + "1. 도서 전체목록 보기  2.도서 검색  3.도서 등록  4.도서 삭제  5.도서 대여처리  6.도서 반납처리  0.사서모드 종료");
			System.out.print(PROMPT);
			String input = sc.next();
			switch(input) {
				case "1" : {
					bookPlay.showBookInfo(); //도서 전체목록 보기 메소드 호출
					break;
				}
				case "2" : {
					bookPlay.searchMenu(); //도서검색 메소드 호출
					break;
				}
				case "3" : {
					bookPlay.addBook(); //도서등록 메소드 호출
					break;
				}
				case "4" : {
					bookPlay.deleteBook(); //도서삭제 메소드 호출
					break;
				}
				case "5" : {
					bookPlay.rendBook(); //도서 대여처리 메소드 호출
					break;
				}
				case "6" : {
					bookPlay.backBook(); //도서 반납처리 메소드 호출
					break;
				}
				case "0" : {
					beginningPage(); //초기화면으로 돌아가기
				}
				default : continue;
			}
		} while(true);		
	} //managerMenu(사서메뉴)메소드 종료
/** 여기까지 사서메뉴 메소드 */	

	
} //main class종료
