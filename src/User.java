
public interface User {

	 /** 메뉴출력*/
	void printUserMenu();
	
	
	/** 1.회원가입  [ID., pw , 이름, Phone번호] */
	void join();
	
	
	/** 2.로그인 */
	void logIn();
	
	/** 3.도서 검색 */
	// bookPlay 클래스의 메서드 활용
	
	/** 4.본인 대여 도서 목록 조회  (가능하다면 반납일 구현)*/
	void viewRentalBooks();
	
	
	/** 5.로그아웃 */
	void logOut();
	
	
	/** 6.회원 탈퇴 */
	void withdrawal();
}
