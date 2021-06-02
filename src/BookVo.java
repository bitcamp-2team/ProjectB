
public class BookVo {
	private String bTitle;
	private String bNum;
	private String bAuthor;
	private String bPublisher;
	private int bStock;
	private boolean loaned;  
	public boolean equals(String bNum) {
		  if (this.bNum.equals(bNum))
		   return true;
		  else
		   return false;
		 }

	//기간 추후 추가 협의
	
	
	/** 생성자 알맞게 수정하세요*/
	public BookVo(String bTitle, String bNum, String bAuthor, String bPublisher, int bStock,boolean loaned) {
		super();
		this.bTitle = bTitle;
		this.bNum = bNum;
		this.bAuthor = bAuthor;
		this.bPublisher = bPublisher;
		this.bStock = bStock;
		this.loaned=loaned;
	}
	public BookVo() {};  //기본생성자
	
	
	/** getter,setter */
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbNum() {
		return bNum;
	}
	public void setbNum(String bNum) {
		this.bNum = bNum;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public String getbPublisher() {
		return bPublisher;
	}
	public void setbPublisher(String bPublisher) {
		this.bPublisher = bPublisher;
	}
	public int getbStock() {
		return bStock;
	}
	public void setbStock(int bStock) {
		this.bStock = bStock;
	}
	 public boolean isLoaned() {
		  return loaned;
		 }

		 public void setLoaned(boolean loaned) {
		  this.loaned = loaned;
		 }
}
