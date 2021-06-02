import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BookPlay implements Book {
	 private ArrayList<Book> booklist;
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
	   if (booklist.get(idx).isLoaned())
	    System.out.println("대여중입니다.");
	   
	   
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
	  String s = sc.nextLine();
	  int idx = findListIndex(s);
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