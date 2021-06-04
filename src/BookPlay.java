import java.util.ArrayList;
import java.util.Scanner;

public class BookPlay implements Book {
	
	final String SUCCESS = "일치하는도서를 출력합니다.";
	final String FAIL = "일치하는 도서가 없습니다. 다시 입력해주세요.";
	final String EMPTY = "등록된 도서가 없습니다.";
	final String MENU = "\n<<<도서검색 메뉴입니다.>>>"; 
	Scanner sc = new Scanner(System.in);
	
	ArrayList<BookVo> booklist = new ArrayList<>(); 

	// 도서검색 메뉴
	@Override
	public void searchMenu() {	
			System.out.println(MENU + "\n1.제목검색 2.저자검색 3.번호검색 4.출판사검색 5.전체조회");
			int menu = sc.nextInt();
			switch(menu) {
				case 1:
					searchForName();
					break;
				case 2:
					searchForAuthor();
					break;
				case 3:
					searchForNum();
					break;
				case 4:
					searchForPublisher();
					break;
				case 5:
					showBookInfo();
					break;
				default:
					System.out.println("메뉴에 있는 번호 입력해주세요");
			}
	}
	
	// 도서제목으로 검색
	@Override
	public void searchForName() {
		System.out.print("도서제목으로 검색합니다.\n제목 입력 : ");
		String BookTitle = sc.next();	
		for(int i = 0; i < booklist.size(); i++) {
				BookVo a = booklist.get(i);
				String num = a.getbTitle(); 
				if(BookTitle.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.bTitle);
					System.out.println("저자 : " + a.bAuthor);
					System.out.println("출판사 : " + a.bPublisher);
					System.out.println("번호 : " + a.bNum);
					System.out.println("재고 : " + a.bStock);
					break;
				} else if(i == booklist.size()-1) {
					System.out.println(FAIL);
				} else if(booklist.equals(null)) {
					System.out.println(EMPTY);
				}
			}
	}
	
	// 도서번호로 검색
	@Override
	public void searchForNum() {
		System.out.print("도서번호로 검색합니다.\n번호 입력 : ");
		String BookNum = sc.next();	
		for(int i = 0; i < booklist.size(); i++) {
				BookVo a = booklist.get(i);
				String num = a.getbNum(); 
				if(BookNum.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.bTitle);
					System.out.println("저자 : " + a.bAuthor);
					System.out.println("출판사 : " + a.bPublisher);
					System.out.println("번호 : " + a.bNum);
					System.out.println("재고 : " + a.bStock);
					break;
				} else if(i == booklist.size()-1) {
					System.out.println(FAIL);
				}
		}
	}
	
	// 도서저자로 검색
	@Override
	public void searchForAuthor() {
		System.out.print("도서저자로 검색합니다.\n저자 입력 : ");
		String BookAuthor = sc.next();	
		for(int i = 0; i < booklist.size(); i++) {
				BookVo a = booklist.get(i);
				String num = a.getbAuthor(); 
				if(BookAuthor.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.bTitle);
					System.out.println("저자 : " + a.bAuthor);
					System.out.println("출판사 : " + a.bPublisher);
					System.out.println("번호 : " + a.bNum);
					System.out.println("재고 : " + a.bStock);
					break;
				} else if(i == booklist.size()-1) {
					System.out.println(FAIL);
				} 
		}
	}
	
	// 도서출판사로 검색
	@Override
	public void searchForPublisher() {
		System.out.print("도서출판사로 검색합니다.\n출판사 입력 : ");
		String BookPublisher = sc.next();	
		for(int i = 0; i < booklist.size(); i++) {
				BookVo a = booklist.get(i);
				String num = a.getbPublisher(); 
				if(BookPublisher.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.bTitle);
					System.out.println("저자 : " + a.bAuthor);
					System.out.println("출판사 : " + a.bPublisher);
					System.out.println("번호 : " + a.bNum);
					System.out.println("재고 : " + a.bStock);
					break;
				} else if(i == booklist.size()-1) {
					System.out.println(FAIL);
				}
		}
	}

	// 전체도서목록 조회
	@Override
	public void showBookInfo() {
    	for(int i = 0; i < booklist.size(); i++) {
    		System.out.printf("======== %d번째 도서 ========%n", i+1);
        	BookVo a = booklist.get(i);
        	System.out.println("제목 : " + a.bTitle);
        	System.out.println("출판사 : " + a.bPublisher);
        	System.out.println("저자 : " + a.bAuthor);
        	System.out.println("번호 : " + a.bNum);
        	System.out.println("재고 : " + a.bStock);
    	}
	}
}