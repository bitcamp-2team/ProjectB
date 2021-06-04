import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	/**공통 문구 / 예쁜디자인 있으면 변경해주세요~*/
	final static String MENU = "[MENU] "; //메뉴 앞에
	final static String PROMPT = ">> ";  //입력창 앞에 
	
	static UserPlay userPlay = new UserPlay();
	static BookPlay bookPlay = new BookPlay();
	
	public static void main(String[] args) { //초기화면 출력 
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
		               BookPlay bookPlay = new BookPlay();
		               while(true) {
		               System.out.println("[1]추가 [2삭제 [3]대출 [4]반납 [0]돌아가기");
		               int select = sc.nextInt();
		               switch(select){
		               case 1 :
		                  bookPlay.addBook();
		                  break;
		               case 2:
		                  bookPlay.deleteBook();
		                  break;
		               case 3:
		                  bookPlay.rendBook();
		                  break;
		               case 4:
		                  bookPlay.backBook();
		                  break;
		               case 0:
		                  break;
		               }
		               }
		          
		            }
				case "0" : {
					sc.close();
					System.exit(0);
				}
				default: continue;
			}
		} while(true);		
	} //main method종료

	
	static void membersMenu() { //일반회원메뉴 출력	
		do {	
			System.out.println(MENU + "1.회원가입  2.로그인  0.초기메뉴");
			System.out.print(PROMPT);
			String input = sc.next();
			switch(input) {
				case "1" : {
					userPlay.join(); //회원가입 메소드 호출
					logInMenu(); //회원가입하면 LogInMenu페이지로 가야함
					break;
				}
				case "2" : {
					userPlay.logIn(); //로그인 메소드 호출
					logInMenu(); //로그인하면 LogInMenu페이지로 가야함
					break;
				}
				case "0" : {
					return; //초기화면으로 돌아가기
				}
				default: continue;
			}
		} while(true);
	} //membersMenu(일반회원메뉴)메소드 종료
	
	
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
					userPlay.logOut(); //로그아웃 메소드 호출
					membersMenu(); //로그아웃하면 membersMenu페이지로 가야 함
				}
				default: continue;
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
					userPlay.withdrawal(); //회원탈퇴 메소드 호출
					membersMenu(); //회원탈퇴하고나면 membersMenu페이지로 가야 함
					break;
				}
				case "0" : {
					logInMenu(); //logInMenu(로그인메뉴) 메소드 호출
					break;
				}
				default: continue;
			}
		} while(true);
	} //myPage(마이페이지)메소드 종료
		
	
// 사서쪽 메뉴 아직 안함...	
//	초기화면에서 2.사서 선택하면
//	사서 로그인!!!!
//	로그인 하면 사서메뉴 나옴
//	사서메뉴 1. 도서 검색  2. 도서 등록/삭제  3. 대여/반납  4.사용종료
//	4.사용종료하면 초기화면으로 가야 함

	
	
	
	
	
} //main class종료
