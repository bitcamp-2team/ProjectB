import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/**공통 문구 / 예쁜디자인 있으면 변경해주세요~*/
		final String MENU="[MENU]"; // 메뉴 앞에
		final String PROMPT=">>";  // 입력창 앞에 
 
		/**공통 저장소입니다. main에서 공토 관리되는 확인이 필요합니다. 안 되면 공유 부탁드립니다 */
		ArrayList<BookVo> BookList = new ArrayList<>(); // 책 리스트
		ArrayList<UserVo> UserList = new ArrayList<>(); // 유저 리스트
		
		
		do {
			System.out.println(MENU+"1.일반회원  2.사서  0.종료");
			System.out.print(">>");
			String input=sc.next();
			switch(input) {
				case "1":{
					BookPlay bookPlay = new BookPlay();
					break;
				}
				case "2":{
					UserPlay userPlay = new UserPlay();
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
