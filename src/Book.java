 public interface Book {
	
	 /** 메뉴출력*/ // 최상->메뉴 출력 및 전체 구조 효미

		/** 1.검색기능 4종 [1.도서제목, 2.책번호, 3.출판사, 4.저자] */
		void searchMenu(); //상    //승옥
		 
		void searchForName();
		void searchForNum();
		void searchForAuthor();
		void searchForPublisher();

		
		/**  2.책 정보 조회*/  //하  //승옥
		void showBookInfo();

		/**  3. 도서 등록   [도서제목, 책번호, 출판사, 저자, 재고] */  //중  //하윤
		void addBook();

		/**  4. 도서 삭제*/   //중  //하윤
		void deleteBook();

		/**  5. 도서 대여*/   //상  // 세은 
		void rendBook();

		/**  6. 도서 반납*/  //상  // 세은 
		void backBook();
}