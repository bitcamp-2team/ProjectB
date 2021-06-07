import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class UserPlay implements User {

	 static int userCount = 0;
	 final String SYSTEM = "[SYSTEM] ";
	 final String SUCCESS = "[성공] ";
	 final String FAILE = "[실패] ";
	 final String MENU="[MENU]"; // 메뉴 앞에
	 final String PROMPT=">>"; 

	Scanner sc = new Scanner(System.in);

	static ArrayList<UserVo> userList = new ArrayList<>(); // 유저 리스트
	
	static UserVo logInUser = null;
	
	public ArrayList<UserVo> getList() {
        return UserPlay.userList;
    }
	
	public static void adminUser() {
		UserVo adminUser = new UserVo("admin", "1234", "admin", "010-1234-1234"); //관리자 계정
		userList.add(adminUser);
	}
	
	public UserPlay() {
		adminUser();
	}
	
	@Override
	public void join() {
		UserVo paper = new UserVo();  //회원가입 작성지

		if (infoID(paper) == -1) { // ID등록을 진행하고 0입력시 종료
			return; // 정상등록시 다음 메서드 진행됨
		} // else의 경우도 실행하면 두번실행됨

		infoPw(paper);

		infoCheckPw(paper);

		if (infoName(paper) == -1) {
			return;
		}

		if (infoPhoneNum(paper) == -1) {
			return;
		}

		userList.add(paper); // 유저리스트에 정보 등록
		userCount++;
	};

	private int infoID(UserVo inputInfo) {
		ID: do {// id입력
			System.out.println("[Step.1]ID를 입력해주세요. (0.메뉴로 돌아가기)");
			System.out.print("ID>> ");
			String inputId = sc.next().trim();
			if (inputId.equals("0")) {
				return -1;
			}
			inputInfo.setId(inputId);
			if (inputId.length() < 3 || 10 < inputId.length()) {
				System.out.println(FAILE + "3~10글자까지만 사용가능합니다.");
				continue;
			}
			for (UserVo userIdList : userList) {
				if (userIdList.getId().equals(inputInfo.getId())) { // id가 있으면
					System.out.println(FAILE + "이미 있는 ID입니다.");
					continue ID;
				}
			}
			System.out.println(SYSTEM + "사용가능한 ID입니다. 사용하시겠습까?[Y/N]");
			String inputYN = sc.next();
			if (inputYN.equalsIgnoreCase("Y")) {
				System.out.println(SUCCESS + "ID를 저장하였습니다.");
				return 1;
			} else {
				continue;
			}
		} while (true);
	} // iffoID 메서드 끝

	private void infoPw(UserVo inputInfo) {
		do {// pw 입력
			System.out.println("[Step.2]PW를 입력해주세요.");
			System.out.print("PW>> ");
			String inputPw = sc.next().trim();
			inputInfo.setPw(inputPw);
			if (checkPw(inputPw)) {
				System.out.println(FAILE + "영문과 숫자만 사용가능합니다.");
			} else if (inputPw.length() < 8 || 20 < inputPw.length()) {
				System.out.println(FAILE + "8~20글자까지만 사용가능합니다.");
			} else {
				System.out.println(SUCCESS + "PW를 임시저장합니다.");
				break;
			}
		} while (true);
	}//infoPw 메서드 끝

	private void infoCheckPw(UserVo inputInfo) {
		do { // pw 확인
			System.out.println("[Step.3]PW를 확인합니다. PW를 입력해주세요.(0.[Step.2]PW재설정 하기)");
			System.out.print("PW>> ");
			String inputPw = sc.next().trim();
			if (inputPw.equals("0")) {
				infoPw(inputInfo);
				continue;
			} else {
				if (!(inputPw.equals(inputInfo.getPw()))) {
					System.out.println(FAILE + "비밀번호가 일치하지 않습니다.");
				} else {
					System.out.println(SYSTEM + "비밀번호가 일치합니다. 사용하시겠습까?[Y/N]");
					String inputYN = sc.next();
					if (inputYN.equalsIgnoreCase("Y")) {
						System.out.println(SUCCESS + "PW가 일치합니다. PW를 저장하였습니다.");
						break;
					} else {
						continue;
					}
				}
			}
		} while (true);
	}//infoCheckPw 메서드 끝
	
	public boolean checkPw(String pw) {
		char[] specialChar = pw.toCharArray();
		for (int i = 0; i < specialChar.length; i++) {
			if ('!' <= specialChar[i] && specialChar[i] <= '/') {
				return true;
			}
		}
		return false;
	} //checkPw 메서드 끝

	private int infoName(UserVo inputInfo) {
		System.out.println("[Step.4]이름을 입력해주세요.(0.메뉴로 돌아가기)");
		System.out.print("NAME>> ");
		String inputName = sc.next().trim();
		inputInfo.setName(inputName);
		if (inputName.equals("0")) {
			return -1;
		} else {
			System.out.println(SUCCESS + "이름이 저장되었습니다.");
			return 1;
		}
	}

	/** ----------------------------전화번호 추가 사항 --------------------------------- */
	private int infoPhoneNum(UserVo inputInfo) {
		System.out.println("[Step.5]전화번호를 입력해주세요.(0.메뉴로 돌아가기)");
		System.out.print("PhoneNumber>> ");
		String inputPhoneNum = sc.next().trim();
		inputInfo.setPhoneNum(inputPhoneNum);
		if (inputPhoneNum.equals("0")) {
			return -1;
		} else {
			System.out.println(SUCCESS + "전화번호가 저장되었습니다.");
			dependAutoSignUp();
			System.out.println(SUCCESS + "★★ 축하합니다. 회원가입이 완료되었습니다.  ★★");
			return 1;
		}
	}//infoPhoneNum 메서드끝

	
	/**---------------------자동가입 방지 추가 사항 ----------------------------- */
	public void dependAutoSignUp() {
		System.out.println("[자동가입 방지]아래 숫자와 동일하게 입력하세요.");
		do {
			int randomNum = (int) (Math.random() * 100000) + 111111;
			System.out.print(randomNum + PROMPT);
			int inputPw = sc.nextInt();
			if (randomNum == inputPw) {
				System.out.println(SUCCESS + "일치합니다.");
				break;
			} else {
				System.out.println(FAILE + "불일치합니다. 다시 시도하세요.");
			}
		} while (true);
	}//dependAutoSignUp 메서드 끝

	@Override
	public void logIn() {
		int countFaile = 0;
		do {
			System.out.print(" ID >> ");
			String inputId = sc.next();
			boolean idFlag = false;
			for (UserVo data : userList) {
				if ((data.getId().equals(inputId))) { // id가 있으면
					idFlag = true;
					logInUser = data; // id가 일치하면 pw를 정보를 불러올 인덱스 설정
					break;
				}
			}
			if (idFlag == false) { // id가 없으면
				System.out.println(FAILE + "없는 ID입니다.");
				continue;
			}

			System.out.print("PW >> ");
			String inputPw = sc.next();

			if (logInUser.getPw().equals(inputPw)) {
				System.out.println(SUCCESS + "로그인 성공~!!");
				break;
			} else {
				System.out.println(FAILE + "비밀번호가 일치하지 않습니다.");
				countFaile++;
				System.out.println(SYSTEM + "입력오류 횟수: " + countFaile);
				if (countFaile == 5) {
					try {
						System.out.println(SYSTEM + "10초 동안 입력을 제한합니다. 10초뒤 시도하세요.");
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}
				if (countFaile == 10) {
					try {
						System.out.println(SYSTEM + "20초 동안 입력을 제한합니다. 20초뒤 시도하세요.");
						TimeUnit.SECONDS.sleep(20);
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}
				continue;
			}

		} while (true);
	}


	@Override
	public void viewRentalBooks() {
		
		System.out.println("사용자 아이디를 입력하세요 :");
		String userId = sc.nextLine();//유저아이디 받기
		
		
	}
	@Override
	public void logOut() {
		do {
			System.out.println("로그아웃 하시겠습니까?[Y/N]");
			System.out.print(">> ");
			String input = sc.next();
			if(input.equalsIgnoreCase("y")) {
				System.out.println(SUCCESS + "로그아웃 되었습니다.");
				logInUser = null;
				return;
			}else if(input.equalsIgnoreCase("n")) {
				return;
			}
		} while (true);

	}
	

	@Override
	public void withdrawal() {
		System.out.println("회원탈퇴를 하시겠습니까?[Y/N]");
		System.out.println(PROMPT);
		if("Y".equalsIgnoreCase(sc.next())) { // Y입력시 do
			do {
				System.out.println("비밀번호를 입력하세요.(0.뒤로가기)");
				System.out.println(PROMPT);
				String input = sc.next();
				if(input.equals("0")) {break;} //0. 뒤로가기
				if(input.equals(logInUser.getPw())) {  //입력 비번과 로그인 유저의 비번확인
					for (UserVo checkId : userList) {
						if(checkId.getId().equals(logInUser.getId())) {
							userList.remove(checkId);
							System.out.println("탈퇴되었습니다. 감사합니다.");
							Main.membersMenu(); // 1이면 membersMenu메뉴로 이동
						}
					}
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
				}	
			}while(true);
		}// Y입력시 종료
		return;  //-1이면 myPage메뉴로 이동
	}//withdrawal 메서드 종료
	
	
	public void managerLogin() {
		Scanner sc = new Scanner(System.in);
		int secret = 1234; // 사서 보안코드

		System.out.println("\n사서 로그인");
		
			

			System.out.println("사서 보안코드 4자리를 입력하세요.");
			if (secret != sc.nextInt()) {
				System.out.println("코드가 일치하지 않아 프로그램을 종료합니다.");
				sc.close();
				System.exit(0);
			} else {
				/*사서 메뉴 출력
				*/
			}
	
	} //사서 로그인 끝
}//UserPlay class 끝 
