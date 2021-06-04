
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BookPlay implements Book {
	final String SUCCESS = "일치하는도서를 출력합니다.";
	final String FAIL = "일치하는 도서가 없습니다. 다시 입력해주세요.";
	final String EMPTY = "등록된 도서가 없습니다.";
	final String MENU = "\n<<<도서검색 메뉴입니다.>>>"; 

	Scanner sc = new Scanner(System.in);
	int num = 0;		//도서 번호
	
	static ArrayList<BookVo> bookList = new ArrayList<>(); 


	// 도서검색 메뉴
	@Override
	public void searchMenu() {	
			outer:
			while(true) {
				System.out.println(MENU + "\n1.제목검색 2.저자검색 3.번호검색 4.출판사검색 5.전체조회 6.도서등록 7.뒤로가기");
				int menu = sc.nextInt();
				switch(menu) {
					case 1:
						searchForName();		// 도서제목검색 메서드
						break;
					case 2:
						searchForAuthor();		// 도서저자검색 메서드
						break;
					case 3:
						searchForNum();			// 도서번호검색 메서드
						break;
					case 4:
						searchForPublisher();	// 도서출판사검색 메서드	
						break;
					case 5:
						showBookInfo();			// 도서목록조회 메서드
						break;
					case 6:
						addBook();				// 도서등록 메서드
						break;
					case 7:
						System.out.println("뒤로가기 성공");
						break outer;			// Main으로 되돌아가기
					default:
						System.out.println("메뉴에 있는 번호 입력해주세요");
						break;					// searchMenu() 처음으로 
				}	// switch문 종료
			}		// while문 종료
	}				// searchMenu() 종료
	
	// 도서제목으로 검색
	@Override
	public void searchForName() {
		System.out.print("도서제목으로 검색합니다.\n제목 입력 : ");
		String BookTitle = sc.next();	
		for(int i = 0; i < bookList.size(); i++) {
				BookVo a = bookList.get(i);
				String num = a.getbTitle(); 
				if(BookTitle.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.getbTitle());
					System.out.println("저자 : " + a.getbAuthor());
					System.out.println("출판사 : " + a.getbPublisher());
					System.out.println("번호 : " + a.getbNum());
					System.out.println("재고 : " + a.getbStock());
					break;
				} else if(i == bookList.size()-1) {
					System.out.println(FAIL);
				} else if(bookList.equals(null)) {
					System.out.println(EMPTY);
				}
			}
	}
	
	// 도서번호로 검색
	@Override
	public void searchForNum() {
		System.out.print("도서번호로 검색합니다.\n번호 입력 : ");

		String BookNum = sc.next();	
		for(int i = 0; i < bookList.size(); i++) {
				BookVo a = bookList.get(i);
				int num = a.getbNum(); 
				if(BookNum.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.getbTitle());
					System.out.println("저자 : " + a.getbAuthor());
					System.out.println("출판사 : " + a.getbPublisher());
					System.out.println("번호 : " + a.getbNum());
					System.out.println("재고 : " + a.getbStock());
					break;
				} else if(i == bookList.size()-1) {
					System.out.println(FAIL);
				}
		}
	}
	
	// 도서저자로 검색
	@Override
	public void searchForAuthor() {
		System.out.print("도서저자로 검색합니다.\n저자 입력 : ");
		String BookAuthor = sc.next();	
		for(int i = 0; i < bookList.size(); i++) {
				BookVo a = bookList.get(i);
				String num = a.getbAuthor(); 
				if(BookAuthor.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.getbTitle());
					System.out.println("저자 : " + a.getbAuthor());
					System.out.println("출판사 : " + a.getbPublisher());
					System.out.println("번호 : " + a.getbNum());
					System.out.println("재고 : " + a.getbStock());
					break;
				} else if(i == bookList.size()-1) {
					System.out.println(FAIL);
				} 
		}

	}
	
	// 도서출판사로 검색
	@Override
	public void searchForPublisher() {

		System.out.print("도서출판사로 검색합니다.\n출판사 입력 : ");
    
		String BookPublisher = sc.next();	
		for(int i = 0; i < bookList.size(); i++) {
				BookVo a = bookList.get(i);
				String num = a.getbPublisher(); 

				if(BookPublisher.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.getbTitle());
					System.out.println("저자 : " + a.getbAuthor());
					System.out.println("출판사 : " + a.getbPublisher());
					System.out.println("번호 : " + a.getbNum());
					System.out.println("재고 : " + a.getbStock());
					break;
				} else if(i == bookList.size()-1) {
					System.out.println(FAIL);
				}
		}
	}
	
	//도서전체목록 조회
	@Override
	public void showBookInfo() {
    	for(int i = 0; i < bookList.size(); i++) {
    		System.out.printf("======== %d번째 도서 ========%n", i+1);

        	BookVo a = bookList.get(i);

        	System.out.println("제목 : " + a.getbTitle());
        	System.out.println("출판사 : " + a.getbPublisher());
        	System.out.println("저자 : " + a.getbAuthor());
        	System.out.println("번호 : " + a.getbNum());
        	System.out.println("재고 : " + a.getbStock());
    	}
	}

	//도서 등록
	@Override
	public void addBook() {
		
		while (true) {
			BookVo bookVo = new BookVo();
			System.out.println("<<도서 등록>>");
            System.out.println("책 제목 :");

            String title = sc.next();
            
            if(findTitle(title)) {			//중복된 도서가 있다면 입력 불가
            	System.out.println("중복된 도서가 있습니다.");
            	break;
            }else {
            	 bookVo.setbTitle(title);
                 System.out.println("작가: ");
            }
            bookVo.setbAuthor(sc.next());
            System.out.println("출판사 :");
            bookVo.setbPublisher(sc.next());
            System.out.println("수량 :");
            while (!sc.hasNextInt()) { 					//값이 숫자인지 판별
                sc.next();  							//값이 숫자가 아니면 버린다.
                System.err.print("숫자만 입력해주세요. \n다시입력 수량: ");
            }
            bookVo.setbStock(sc.nextInt());				//위에서 값이 숫자일 경우 이쪽으로 값을 넣어준다.
            
 
            /**확인하기*/
            System.out.println(bookVo.getbTitle() + "/" + bookVo.getbAuthor() + "/" + bookVo.getbPublisher() + "/" +bookVo.getbStock());            
            System.out.println("입력하신 사항이 모두 맞습니까?");           
            System.out.println("[YES] 1/ [NO] 2");
            int check = sc.nextInt();
            
            if (check == 1) {
            	bookList.add(bookVo);
                num++;						//도서번호에 1씩 증가하는 번호 부여
                bookVo.setbNum(num);
                System.out.println("도서 번호:" + bookVo.getbNum());
                System.out.println(bookVo.getbTitle() + "/" + bookVo.getbAuthor() + "/" + bookVo.getbPublisher() + "/" +
                		bookVo.getbStock());
                System.out.println("등록 완료");
                sc.nextLine();
                break;
            } else if (check == 2) {
                System.out.println("다시 입력해주세요");
                sc.nextLine();
            } else {
                System.out.println("잘못 누르셨습니다. 메인 화면으로 이동합니다");
                break; 
            } //end if-else
            }// end while
       } 
	

	private boolean findTitle(String title) {	//중복된 도서가 있는지 확인
		for (int i = 0; i < bookList.size(); i++) {
			   if (bookList.get(i).getbTitle().equals(title))
			    return true;
			  }
			  return false;
		}


	//도서 삭제(제목 이용)
	@Override
	public void deleteBook() {
		String name;
        System.out.println("<<도서 삭제 >>");
		 while (true) {
		        sc.nextLine();
	            System.out.println("삭제 할 도서 제목을 입력해주세요");
	            name = sc.nextLine();
	            int cnt = 0;
	            for (int i = 0; i < bookList.size(); i++) {
	                if (name.equals(bookList.get(i).getbTitle())) {
	                	System.out.println(bookList.get(i).getbTitle() + "를 정말 삭제하겠습니까?");
	                	System.out.println("[YES]1 / [NO]2 / [돌아가기]0");
	                	int select = sc.nextInt();
	                	if(select == 1) {
	                		bookList.remove(i);
		                    cnt++;
		                    System.out.println("도서 삭제 완료");
		                    sc.nextLine();
		                    break;
	                	}else if(select == 2) {
	                		System.out.println("다시 입력하세요");
	                		sc.nextLine();
	                		cnt++;
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
	   if (bookList.get(idx).isLoaned()) {
	    System.out.println("대여중입니다.");}
	   
	   else {
	    System.out.println("대여완료");
	    System.out.println("대여일 : "+df.format(cal.getTime()));
	    cal.add(Calendar.DATE,7);
	    System.out.println("반납일 : "+df.format(cal.getTime()));
	    bookList.get(idx).setLoaned(true);
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
	   if (bookList.get(idx).isLoaned()) {
	    System.out.println("반납 완료.");
	    cal.add(Calendar.DATE,7);
	    System.out.println("반납일 : "+df.format(cal.getTime()));
	   } else
	    System.out.println("대여중인 도서가 아닙니다.");
	  }
	 }

	 public int findListIndex(String id) {
	  for (int i = 0; i < bookList.size(); i++) {
	   if (bookList.get(i).equals(id)){
	    return i;
     }
	  }
	  return -1;
	 }


	 public boolean findId(String id) {
	  for (int i = 0; i < bookList.size() - 1; i++) {
	   if (bookList.get(i).equals(id))
	    return true;
	  }
	  return false;
	}

}
	 
