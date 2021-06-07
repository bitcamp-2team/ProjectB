
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class BookPlay implements Book {

	final String SUCCESS = "일치하는도서를 출력합니다.";
	final String FAIL = "일치하는 도서가 없습니다. 다시 입력해주세요.";
	final String EMPTY = "등록된 도서가 없습니다.";
	final String MENU = "\n<<<도서검색 메뉴입니다.>>>"; 
  final String BACK = "[뒤로가기 성공]";
  BookVo bookVo = new BookVo();

	


	Scanner sc = new Scanner(System.in);
	int num = 0;		//도서 번호
	
	static ArrayList<BookVo> bookList = new ArrayList<>(); 
	static ArrayList<BookRendVo> rendBooks = new ArrayList<BookRendVo>();
	 

	// 도서검색 메뉴
	@Override
	public void searchMenu() {	
			outer:
			while(true) {
				System.out.println(MENU + "\n1.제목검색 2.저자검색 3.번호검색 4.출판사검색 5.뒤로가기");
				String menu = sc.next();
				switch(menu) {
					case "1":
						searchForName();		// 도서제목검색 메서드
						break;
					case "2":
						searchForAuthor();		// 도서저자검색 메서드
						break;
					case "3":
						searchForNum();			// 도서번호검색 메서드
						break;
					case "4":
						searchForPublisher();	// 도서출판사검색 메서드	
						break;
					case "5":
						System.out.println(BACK);
						break outer;
					default:
						System.out.println("[메뉴에 있는 번호를 입력해주세요.]");
						break;					// searchMenu() 처음으로
				}	// switch문 종료
			}	// while문 종료
	}	// searchMenu() 종료
	
	// 도서제목으로 검색
	@Override
	public void searchForName() {
		outer:
		do {
			System.out.print("[도서제목으로 검색] (뒤로가기 : 0)\n제목 입력 : ");
			String BookTitle = sc.next();	
			
			if(BookTitle.equalsIgnoreCase("0")) {
				System.out.println(BACK);
				break;
			}	
			
			if(bookList.size() == 0) {
				System.out.println("현재 등록된 도서가 없습니다. 등록하시겠습니까? \n1.네 0.뒤로가기");
				String menu = sc.next();
				switch(menu) {
					case "1":
						addBook();
					case "0":
						System.out.println(BACK);
						break outer;
					default:
						System.out.println("[잘못 입력하셨습니다.]\n[검색메뉴로 돌아갑니다.]");
						break outer;
				}	// switch문 종료
			}	// if문 종료
		
			for(int i = 0; i < bookList.size(); i++) {
				BookVo a = bookList.get(i);
				String num = a.getbTitle(); 
				if(BookTitle.equalsIgnoreCase(num)) {
					System.out.println(SUCCESS);
					System.out.println("제목 : " + a.getbTitle());
					System.out.println("저자 : " + a.getbAuthor());
					System.out.println("출판사 : " + a.getbPublisher());
					System.out.println("번호 : " + a.getbNum());
					System.out.println("재고 : " + a.getbStock() + "\n");
					break;
				} else if(i == bookList.size()-1) {
					System.out.println(FAIL);
					continue outer;
				}
			}	// for문 종료
		} while(true);	// do-while문 종료
	}	// searchForName() 종료
	
	// 도서번호로 검색
	@Override
	public void searchForNum() {
			outer:
			do {
				System.out.print("[도서번호로 검색](뒤로가기 : 0)\n번호 입력 : ");
				while (!sc.hasNextInt()) {	// 입력받은 값이 숫자가 아닐 때 					
					sc.next();  			// 입력받은 값 삭제				
					System.err.print("숫자만 입력가능합니다.\n다시 입력 : ");
				}

				int BookNum = sc.nextInt();
				if(BookNum == 0) {
					System.out.println(BACK);
					break outer;
				}
        
				if(bookList.size() == 0) { 
					System.out.println("[현재 등록된 도서가 없습니다. 등록하시겠습니까?]\n[1.네 2.아니오]");
					String menu = sc.next();
					switch(menu) {
						case "1":
							addBook();
						case "0":
							System.out.println(BACK);
							break outer;
						default:
							System.out.println("[잘못 입력하셨습니다.]\n[검색메뉴로 돌아갑니다.]");
							break outer;
					}	// switch문 종료
				}	// if문 종료
				
				for(int i = 0; i < bookList.size(); i++) {
					BookVo a = bookList.get(i);
					int num = a.getbNum();
					if(BookNum == num) {
						System.out.println(SUCCESS);
						System.out.println("제목 : " + a.getbTitle());
						System.out.println("저자 : " + a.getbAuthor());
						System.out.println("출판사 : " + a.getbPublisher());
						System.out.println("번호 : " + a.getbNum());
						System.out.println("재고 : " + a.getbStock());
					} else {
						System.out.println(FAIL);
						break;
					}
				}	// for문 종료	
			} while(true);	// do-while문 종료
	}	// searchForNum() 종료
			
	// 도서저자로 검색
	@Override
	public void searchForAuthor() {
		outer:
		do {
			System.out.printf("[도서저자로 검색](뒤로가기 : 0)\n저자 입력 : ");
			String BookAuthor = sc.next();
			
			if(BookAuthor.equalsIgnoreCase("0")) {
				System.out.println(BACK);
				break;
			}
			
			if(bookList.size() == 0) {
				System.out.println("현재 등록된 도서가 없습니다. 등록하시겠습니까? \n1.네 0.뒤로가기");
				String menu = sc.next();
				switch(menu) {
					case "1":
						addBook();
					case "0":
						System.out.println(BACK);
						break outer;
					default:
						System.out.println("[잘못 입력하셨습니다.]\n[검색메뉴로 돌아갑니다.]");
						break outer;
				}	// switch문 종료
			}	// if문 종료
			
			for(int i = 0; i < bookList.size(); i++) {
				BookVo a = bookList.get(i);
				if(BookAuthor.equalsIgnoreCase(a.getbAuthor())) {
					System.out.printf("======== %d번째 도서 ========%n", i+1);
					System.out.println("제목 : " + a.getbTitle());
					System.out.println("저자 : " + a.getbAuthor());
					System.out.println("출판사 : " + a.getbPublisher());
					System.out.println("번호 : " + a.getbNum());
					System.out.println("재고 : " + a.getbStock());
				} else {
					System.out.println(FAIL);
					break;
				}
		}	// for문 종료
		} while(true); // do-while문 종료
	}	// searchForAuthor() 종료
	
	// 도서출판사로 검색
	@Override
	public void searchForPublisher() {
		outer:
		do {
			System.out.print("[도서출판사로 검색.](뒤로가기 : 0)\n출판사 입력 : ");
			String BookPublisher = sc.next();	
			
			if(BookPublisher.equalsIgnoreCase("0")) {
				System.out.println(BACK);
				break;
			}
			
			if(bookList.size() == 0) {
				System.out.println("현재 등록된 도서가 없습니다. 등록하시겠습니까? \n1.네 0.뒤로가기");
				String menu = sc.next();
				switch(menu) {
					case "1":
						addBook();
					case "0":
						System.out.println(BACK);
						break outer;
					default:
						System.out.println("[잘못 입력하셨습니다.]\n[검색메뉴로 돌아갑니다.]");
						break outer;
				}	// switch문 종료
			}	// if문 종료
			
			for(int i = 0; i < bookList.size(); i++) {
				BookVo a = bookList.get(i);
	        	if(BookPublisher.equalsIgnoreCase(a.getbPublisher())) {
	        		System.out.printf("======== %d번째 도서 ========%n", i+1);
	            	System.out.println("제목 : " + a.getbTitle());
	            	System.out.println("출판사 : " + a.getbPublisher());
	            	System.out.println("저자 : " + a.getbAuthor());
	            	System.out.println("번호 : " + a.getbNum());
	            	System.out.println("재고 : " + a.getbStock());
	        	} else {
	        		System.out.println(FAIL);
	        		break;
	        	}
			}	// for문 종료
		} while(true);
	}	// searchForPublisher() 종료
	
	//도서전체목록 조회
	@Override
	public void showBookInfo() {
		outer:
		do {
			if(bookList.size() == 0) {
				System.out.println("[등록된 도서가 0권입니다. 등록하시겠습니까?]\n[1.네 0.뒤로가기]");
				String menu = sc.next();
				switch(menu) {
				case "1":
					addBook();
					break outer;
				case "0":
					System.out.println(BACK);
					break outer;
				default:
					System.out.println("[잘못 입력하셨습니다.]\n[메인메뉴로 돌아갑니다.]");
					break outer;
				}	// switch문 종료
			}	// if문 종료
			
			for(int i = 0; i < bookList.size(); i++) {
				System.out.printf("======== %d번째 도서 ========%n", i+1);
				BookVo a = bookList.get(i);
				System.out.println("제목 : " + a.getbTitle());
				System.out.println("출판사 : " + a.getbPublisher());
				System.out.println("저자 : " + a.getbAuthor());
				System.out.println("번호 : " + a.getbNum());
        		System.out.println("재고 : " + a.getbStock() + "\n");
        		break outer;
			}	// for문 종료
		} while(true);	// do-while문 종료
	}
	//도서 등록
		@Override
		public void addBook() {
			
			while (true) {
				BookVo bookVo = new BookVo();
				System.out.println("<<도서 등록>>");
				System.out.println("[되돌아가기]: 0");
	            System.out.println("책 제목 :");

	            String title = sc.next();
	            if(title.equals("0")) {break;}	//되돌아가기
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
	            System.out.println("[YES] 1/ [NO] 2 [돌아가기] 0");
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
	            }else if(check == 0) {
	            	break;
	            } else {
	                System.out.println("잘못 누르셨습니다. 메뉴로 이동합니다");
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


		/**도서 삭제 */
		@Override
		public void deleteBook() {	
	        System.out.println("<<도서 삭제 >>");
	        System.out.println("[제목으로 삭제]1 / [도서 번호로 삭제]2 / [돌아가기] 0");
	        int sel = sc.nextInt();
	        
	        
	        switch(sel) {
	        case 1:
	        	deleteTitle();
	        	break;
	        case 2:
	        	deleteNum();
	        	break;
	        case 0:						//돌아가기
	        	break;
	        default:
	        	System.out.println("잘못 누르셨습니다. 메인 화면으로 이동합니다");
	        	break;
	        }	
		}
		
		/**도서 번호 이용한 도서 삭제 */
		private void deleteNum() {
			 int num;
			 while (true) {
			        sc.nextLine();
		            System.out.println("삭제 할 도서 번호를 입력해주세요");
		            num = sc.nextInt();
		            int cnt = 0;
		            for (int i = 0; i < bookList.size(); i++) {
		                if (num == bookList.get(i).getbNum()) {
		                	System.out.println(bookList.get(i).getbTitle() + "를 정말 삭제하겠습니까?");
		                	System.out.println("[YES]1 / [NO]2 / [돌아가기] 0");
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
		                	}else if(select == 0) {
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
		/**도서 제목 이용한 도서 삭제 */
		private void deleteTitle() {
			String name;
			 while (true) {
			        sc.nextLine();
		            System.out.println("삭제 할 도서 제목을 입력해주세요");
		            name = sc.nextLine();
		            int cnt = 0;
		            for (int i = 0; i < bookList.size(); i++) {
		                if (name.equals(bookList.get(i).getbTitle())) {
		                	System.out.println(bookList.get(i).getbTitle() + "를 정말 삭제하겠습니까?");
		                	System.out.println("[YES]1 / [NO]2 /[돌아가기] 0");
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
		                	}else if(select == 0) {
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
	      BookRendVo userid = new BookRendVo();
	      
	      Scanner sc = new Scanner(System.in);
	      Calendar cal =Calendar.getInstance();
	      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	      
	      System.out.print("대여할 책 번호를 입력하세요 : (0.돌아가기)");
	      String bNum = sc.nextLine(); // 사서로부터 책번호 입력 받기
	      int idx = findListIndex(bNum);
	      
	      if (bNum.equals("0")) {
				System.out.println("돌아가기 성공");
				return;
				}  //0 누르면 되돌아가기
	      
	      System.out.print("대여자 ID를 입력하세요 : (0.돌아가기)"); // 사서로부터 UserId 입력 받기
	      String userId = sc.next();
	      userid.getUserId();
	      
	      if (userId.equals("0")) {
				System.out.println("돌아가기 성공");
				return;
				}
	      if (idx == -1)
	            System.out.println("등록되지 않은 책번호입니다.");
	           
	      else if (bookList.get(idx).isLoaned()) {
	             System.out.println("대여중입니다.");}
	           
	      else {
	       System.out.println("대여완료");
	         
	      // 매개변수로 받은 대출할 도서의 번호, 사용자ID, 오늘 날짜로 BookRendVo 객체를 만든다.
	      BookRendVo bookRendVo = new BookRendVo(bNum, userId, df.format(cal.getTime()));
	      
	      bookRendVo.setRendBookDate(df.format(cal.getTime()));
	      System.out.println("대여일 : "+df.format(cal.getTime()));
	      
	      cal.add(Calendar.DATE,7);
	      bookRendVo.setBackBookDate(df.format(cal.getTime()));
	      System.out.println("반납일 : "+df.format(cal.getTime()));
	      
	      rendBooks.add(bookRendVo); // BookRendVo 객체를 rendBooks 리스트에 추가한다.
	      bookList.get(idx).setLoaned(true); // 대충 대출중 이라는 뜻
	        }
	    }
	


	@Override
	public void backBook() {
		 BookRendVo userid = new BookRendVo();
		 
		 Scanner sc = new Scanner(System.in);
			Calendar cal =Calendar.getInstance();
		     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		     
		      System.out.print("반납할 책 번호를 입력하세요 : (0.돌아가기)");
		      String bNum = sc.nextLine(); // 사서로부터 책번호 입력 받기
		      int idx = findListIndex(bNum);
		      
		      if (bNum.equals("0")) {  //0누르면 되돌아가기
					System.out.println("돌아가기 성공");
		    	  return;}
		      
		      System.out.print("반납자 ID를 입력하세요 : (0.돌아가기)"); // 사서로부터 UserId 입력 받기
		      String userId = sc.nextLine();
		      userid.getUserId();
		      
		      if (userId.equals("0")) {  //0누르면 되돌아가기
					System.out.println("돌아가기 성공");
		    	  return;}
		      if (idx == -1) {
		            System.out.println("등록되지 않은 번호입니다.");}
		          
		      else {
		       System.out.println("반납완료");
		       System.out.println("반납일 :"+df.format(cal.getTime()));
		       
		       BookRendVo bookRendVo = new BookRendVo(bNum, userId, df.format(cal.getTime()));
		       rendBooks.remove(bookRendVo);
		       bookList.get(idx).setLoaned(false);
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
	

