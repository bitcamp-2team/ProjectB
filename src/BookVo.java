
public class BookVo {
	String bTitle;		// 도서제목
	static int bNum;	// 도서번호 static int로 변경
	String bAuthor;		// 도서저자
	String bPublisher;	// 도서출판사
	int bStock;			// 도서재고
	
	public BookVo(String bTitle, int bNum, String bAuthor, String bPublisher, int stock) {
		super();
		this.bTitle = bTitle;
		this.bNum = bNum;
		this.bAuthor = bAuthor;
		this.bPublisher = bPublisher;
		this.bStock = stock;
	}

	public BookVo() {};  //기본생성자

	
	public String getbTitle() { return bTitle; }
	public void setbTitle(String bTitle) { this.bTitle = bTitle; }
	
	public int getbNum() { return bNum; }
	public void setbNum(int num) { this.bNum = num; }
	
	public String getbAuthor() { return bAuthor; }
	public void setbAuthor(String bAuthor) { this.bAuthor = bAuthor; }
	
	public String getbPublisher() { return bPublisher; }
	public void setbPublisher(String bPublisher) { this.bPublisher = bPublisher; }
	
	public int getbStock() { return bStock; }
	public void setbStock(int bStock) { this.bStock = bStock; }
}