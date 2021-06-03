
public class BookVo {
	private String bTitle;
	private static int bNum;
	private String bAuthor;
	private String bPublisher;
	private int bStock;
	private boolean Loaned;  
	boolean equals(String id) {
		  if (this.bNum==Integer.parseInt(id)) {
		   return true;}
		  else {
		   return false;}
		 }

	//湲곌컙 異뷀썑 異붽� �삊�쓽
	
	
	/** �깮�꽦�옄 �븣留욊쾶 �닔�젙�븯�꽭�슂*/
	public BookVo(String bTitle, int bNum, String bAuthor, String bPublisher, int bStock,boolean Loaned) {
		super();
		this.bTitle = bTitle;
		this.bNum = bNum;
		this.bAuthor = bAuthor;
		this.bPublisher = bPublisher;
		this.bStock = bStock;
		this.Loaned=Loaned;
		
	}
	public BookVo() {};  //湲곕낯�깮�꽦�옄
	
	
	/** getter,setter */
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
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
		  return Loaned;
		 }

		 public void setLoaned(boolean Loaned) {
		  this.Loaned = Loaned;
		 }
}
