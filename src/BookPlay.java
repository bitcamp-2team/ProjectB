
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BookPlay implements Book {

	BookVo bookVo = new BookVo();
	Scanner sc = new Scanner(System.in);
	int num = 0;		//도서 번호
	

	 private ArrayList<BookVo> booklist = new ArrayList<>();
	@Override
	public void printBookMenu(){
	}
	
	@Override
	public void searchMenu() {	
	}
	
	@Override
	public void searchForName() {
	}
	@Override
	public void searchForNum(){
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

	//도서 등록
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
            	booklist.add(bookVo);
                num++;						//도서번호에 1씩 증가하는 번호 부여
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
	
	//도서 삭제(제목 이용)

	@Override
	public void deleteBook() {
		String name;
		 while (true) {
	            System.out.println("삭제 할 도서 제목을 입력해주세요");
	            name = sc.nextLine();
	            int cnt = 0;
	            for (int i = 0; i < booklist.size(); i++) {
	                if (name.equals(booklist.get(i).getbTitle())) {
	                	System.out.println(booklist.get(i).getbTitle() + "를 정말 삭제하겠습니까?");
	                	System.out.println("[YES]1 / [NO]2 / [돌아가기]0");
	                	int select = sc.nextInt();
	                	if(select == 1) {
	                		booklist.remove(i);
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

	@Override
	public void printBookMenu() {
	}
	}
	 
