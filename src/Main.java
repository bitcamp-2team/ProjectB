import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/**공통 문구 / 예쁜디자인 있으면 변경해주세요~*/
		final String MENU="[MENU]"; // 메뉴 앞에
		final String PROMPT=">>";  // 입력창 앞에 
 
		do {
			System.out.println(MENU+"1.일반회원  2.사서  0.종료");
			System.out.print(PROMPT);
			String input=sc.next();
			switch(input) {
				case "1":{
					UserPlay userPlay = new UserPlay();
					userPlay.mainMenu(); //작동 확인 시 삭제 예정 
					break;
				}
				case "2":{
					BookPlay bookPlay = new BookPlay();
					bookPlay.searchMenu();
					break;
				}
				case "0":{
					sc.close();
					System.exit(0);
				}
				default: continue;
			}
		}while(true);
		
	}//main method종료
} // main class종료
