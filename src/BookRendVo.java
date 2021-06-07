
public class BookRendVo {
	/*
	 @Param
	  책의 등록번호, 대출자 번호, 대출일, 반납일,  책 상태, 반납상태(보류), 연체일수  
	 */
	private String bNum;
	private String userId;
	private String rendBookDate;
	private String backBookDate;
	
	//private int checkOutbookStatus; //0: 반납완료, 1: 대출중, 2: 연체중
	private int overdueDays;
	
	public BookRendVo() {}

	
	public BookRendVo(String bNum, String userId, String rendBookDate) {
		this.bNum = bNum;
		this.userId = userId;
		this.rendBookDate = rendBookDate;
	}


	public String getbNum() {
		return bNum;
	}


	public void setbNum(String bNum) {
		this.bNum = bNum;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getRendBookDate() {
		return rendBookDate;
	}


	public void setRendBookDate(String rendBookDate) {
		this.rendBookDate = rendBookDate;
	}


	public String getBackBookDate() {
		return backBookDate;
	}


	public void setBackBookDate(String backBookDate) {
		this.backBookDate = backBookDate;
	}


	public int getOverdueDays() {
		return overdueDays;
	}


	public void setOverdueDays(int overdueDays) {
		this.overdueDays = overdueDays;
	}
	
	
}

