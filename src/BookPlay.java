import java.util.ArrayList;
import java.util.Scanner;

public class BookPlay implements Book {
	BookVo bookVo = new BookVo();
	Scanner sc = new Scanner(System.in);
	int num = 0;
	
	static ArrayList<BookVo> BookList = new ArrayList<>(); 
	
	@Override
	public void searchMenu() {	
	}
	
	@Override
	public void searchForName() {
	}
	@Override
	public void searchForNum() {
	}
		
	@Override
	public void searchForAuthor() {
	}
		
	@Override
	public void searchForPublisher() {
	}
	
	@Override
	public void showBookInfo() {
	}

	@Override
	public void addBook() {
		while (true) {
            System.out.println("책 제목 :");
            bookVo.setbTitle(sc.nextLine());
            System.out.println("작가: ");
            bookVo.setbAuthor(sc.nextLine());
            System.out.println("출판사 :");
            bookVo.setbPublisher(sc.nextLine());
            System.out.println("수량 :");
            bookVo.setbStock(sc.nextInt());
 
            /**확인하기*/
            System.out.println(bookVo.getbTitle() + "/" + bookVo.getbAuthor() + "/" + bookVo.getbPublisher() + "/" +bookVo.getbStock());            
            System.out.println("입력하신 사항이 모두 맞습니까?");           
            System.out.println("[YES] 1/ [NO] 2");
            int check = sc.nextInt();
            
            if (check == 1) {
            	BookList.add(bookVo);
                num++;						//1씩 증가하는 번호 부여
                bookVo.setbNum(num);
                System.out.println(bookVo.getbNum() + "/" + bookVo.getbTitle() + "/" + bookVo.getbAuthor() + "/" + bookVo.getbPublisher() + "/" +
                		bookVo.getbStock());
                System.out.println("등록 완료");
                sc.nextLine();
                break;
            } else if (check == 2) {
                System.out.println("다시 입력해주세요");
            } else {
                System.out.println("잘못 누르셨습니다. 메인 화면으로 이동합니다");
                break; 
            } //end if-else
            }// end while
       } 

	@Override
	public void deleteBook() {
		String name;
		 while (true) {
	            System.out.println("삭제 할 도서 제목을 입력해주세요");
	            name = sc.nextLine();
	            int cnt = 0;
	            for (int i = 0; i < BookList.size(); i++) {
	                if (name.equals(BookList.get(i).getbTitle())) {
	                	System.out.println(BookList.get(i).getbTitle() + "를 정말 삭제하겠습니까?");
	                	System.out.println("[YES]1 / [NO]2 / [돌아가기]0");
	                	int select = sc.nextInt();
	                	if(select == 1) {
	                		BookList.remove(i);
		                    cnt++;
		                    System.out.println("도서 삭제 완료");
		                    sc.nextLine();
		                    break;
	                	}else if(select == 2) {
	                		System.out.println("다시 입력하세요");
	                		break;
	                	}else {
	                		System.out.println("잘못 누르셨습니다. 메인 화면으로 이동합니다");
	                        break;
	                	}	                		
	                }
	            } // end for
	            if (cnt == 0) {
	                System.out.println("해당 도서가 존재하지 않습니다. 다시 입력하세요.");
	            } else {
	                break;// 메인으로
	            }
	        } // end while
	}

	@Override
	public void rendBook() {
	}

	@Override
	public void backBook() {
	}
}