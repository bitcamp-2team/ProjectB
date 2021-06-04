
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BookPlay implements Book {
	
	Scanner sc = new Scanner(System.in);
	 BookVo bookVo = new BookVo();
	 private ArrayList<BookVo> booklist;
	
	 @Override
	 public void printBookMenu() {
	 }
	 

	@Override
	public void searchMenu() {	
		while(true) {
			System.out.println(MENU + "\n1.제목검색 2.저자검색 3.번호검색 4.출판사검색 5.등록 6. 전체조회");
			int menu = sc.nextInt();
			if('0' <= menu && menu <= '9') {
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
					add();
					break;
				case 6:
					showBookInfo();
					break;
				default:
					System.out.println("메뉴에 있는 번호 입력해주세요");
			} 
		} else {
			System.out.println("메뉴에있는숫자입력");
		}
	}
	}
	
	// 도서제목으로 검색
	@Override
	public void searchForName() {
		System.out.print("도서제목으로 검색합니다.\n제목 입력 : ");
		String BookTitle = sc.next();	
		for(int i = 0; i < BookList.size(); i++) {
				BookVo a = BookList.get(i);
				String num = a.getbTitle(); 
				if(BookTitle.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.bTitle);
					System.out.println("저자 : " + a.bAuthor);
					System.out.println("출판사 : " + a.bPublisher);
					System.out.println("번호 : " + a.bNum);
					System.out.println("재고 : " + a.bStock);
					break;
				} else if(i == BookList.size()-1) {
					System.out.println(FAIL);
				} else if(BookList.equals(null)) {
					System.out.println(EMPTY);
				}
			}
	}
	
	// 도서번호로 검색
	@Override
	public void searchForNum() {
		System.out.print("도서번호로 검색합니다.\n번호 입력 : ");
		String BookNum = sc.next();	
		for(int i = 0; i < BookList.size(); i++) {
				BookVo a = BookList.get(i);
				String num = a.getbNum(); 
				if(BookNum.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.bTitle);
					System.out.println("저자 : " + a.bAuthor);
					System.out.println("출판사 : " + a.bPublisher);
					System.out.println("번호 : " + a.bNum);
					System.out.println("재고 : " + a.bStock);
					break;
				} else if(i == BookList.size()-1) {
					System.out.println(FAIL);
				}
		}
	}
	
	// 도서저자로 검색
	@Override
	public void searchForAuthor() {
		System.out.print("도서저자로 검색합니다.\n저자 입력 : ");
		String BookAuthor = sc.next();	
		for(int i = 0; i < BookList.size(); i++) {
				BookVo a = BookList.get(i);
				String num = a.getbAuthor(); 
				if(BookAuthor.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.bTitle);
					System.out.println("저자 : " + a.bAuthor);
					System.out.println("출판사 : " + a.bPublisher);
					System.out.println("번호 : " + a.bNum);
					System.out.println("재고 : " + a.bStock);
					break;
				} else if(i == BookList.size()-1) {
					System.out.println(FAIL);
				} 
		}
	}
	
	// 도서출판사로 검색
	@Override
	public void searchForPublisher() {
		System.out.print("도서출판사로 검색합니다.\n출판사 입력 : ");
		String BookPublisher = sc.next();	
		for(int i = 0; i < BookList.size(); i++) {
				BookVo a = BookList.get(i);
				String num = a.getbPublisher(); 
				if(BookPublisher.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.bTitle);
					System.out.println("저자 : " + a.bAuthor);
					System.out.println("출판사 : " + a.bPublisher);
					System.out.println("번호 : " + a.bNum);
					System.out.println("재고 : " + a.bStock);
					break;
				} else if(i == BookList.size()-1) {
					System.out.println(FAIL);
				}
		}
	}

	// 전체도서목록 조회
	@Override
	public void showBookInfo() {
    	for(int i = 0; i < BookList.size(); i++) {
    		System.out.printf("======== %d번째 도서 ========%n", i+1);
        	BookVo a = BookList.get(i);
        	System.out.println("제목 : " + a.bTitle);
        	System.out.println("출판사 : " + a.bPublisher);
        	System.out.println("저자 : " + a.bAuthor);
        	System.out.println("번호 : " + a.bNum);
        	System.out.println("재고 : " + a.bStock);
    	}
	}

	@Override
	public void addBook() {
		
       } 

	@Override
	public void deleteBook() {
	}
	

	@Override
	public void rendBook() {
		 Scanner sc = new Scanner(System.in);
			Calendar cal =Calendar.getInstance();
		     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		     
	  System.out.println("대여할 책 번호를 입력하세요 : ");
	  String bNum = sc.nextLine();
	  int idx = findListIndex(bNum);
	  if (idx == -1)
	   System.out.println("등록되지 않은 번호입니다.");
	  else {
	   if (booklist.get(idx).isLoaned()) {
	    System.out.println("대여중입니다.");}
	   
	   else {
	    System.out.println("대여완료");
	    System.out.println("대여일 : "+df.format(cal.getTime()));
	    cal.add(Calendar.DATE,7);
	    System.out.println("반납일 : "+df.format(cal.getTime()));
	    booklist.get(idx).setLoaned(true);
	   }
	  }
	 }

	@Override
	public void backBook() {

		 Scanner sc = new Scanner(System.in);
			Calendar cal =Calendar.getInstance();
		     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	  System.out.println("반납할 책의 번호를 입력하세요");
	  String bNum = sc.nextLine();
	  int idx = findListIndex(bNum);
	  if (idx == -1)
	   System.out.println("등록되지 않은 번호입니다.");
	  else {
	   if (booklist.get(idx).isLoaned()) {
	    System.out.println("반납 완료.");
	    cal.add(Calendar.DATE,7);
	    System.out.println("반납일 : "+df.format(cal.getTime()));
	   } else
	    System.out.println("대여중인 도서가 아닙니다.");
	  }
	 }

	 public int findListIndex(String id) {
	  for (int i = 0; i < booklist.size(); i++) {
	   if (booklist.get(i).equals(id))
	    return i;
	  }
	  return -1;
	 }

	 public boolean findId(String id) {
	  for (int i = 0; i < booklist.size() - 1; i++) {
	   if (booklist.get(i).equals(id))
	    return true;
	  }
	  return false;
	}
	}
	 
