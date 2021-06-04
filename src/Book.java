 public interface Book {
	

	 /** 메뉴출력*/
	void printBookMenu();

	/** 1.검색기능 4종 [1.도서제목,2.책번호,3.출판사,4.저자]*/
	void searchMenu(); 
	void searchForName();
	void searchForNum();
	void searchForAuthor();
	void searchForPublisher();

	/**  책 정보 조회*/
	void showBookInfo();
	
	/** 도서 등록[도서제목,책번호,출판사,저자 재고]*/
	void addBook();

	/**  4. 도서 삭제*/
	void deleteBook();
	
	/**  5. 도서 대여*/
	void rendBook();
	
	/**  6. 도서 반납*/
	void backBook();

	