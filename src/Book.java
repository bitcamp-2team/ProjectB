
 public interface Book {
	
	 /** �޴����*/ // �ֻ�->�޴� ��� �� ��ü ���� ȿ��
	

	/** 1.�˻���� 4�� [1.��������, 2.å��ȣ, 3.���ǻ�, 4.����] */
	void searchMenu(); //��    //�¿�
	 
	void searchForName();
	void searchForNum();
	void searchForAuthor();
	void searchForPublisher();

	/**  2.å ���� ��ȸ*/  //��  //�¿�
	void showBookInfo();
	
	/**  3. ���� ���   [��������, å��ȣ, ���ǻ�, ����, ���] */  //��  //����
	void addBook();

	/**  4. ���� ����*/   //��  //����
	void deleteBook();
	
	/**  5. ���� �뿩*/   //��  // ���� 
	void rendBook();
	
	/**  6. ���� �ݳ�*/  //��  // ���� 
	void backBook();
	
	
}
