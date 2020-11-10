package kr.or.bit.model.DTO;

public class SellerDTO {
	private int Sel_Num;
	private String Id;
	private String Sel_Email;
	private int Sel_Regist_Num;
	private String Sel_Account;
	
	
	public int getSel_Num() {
		return Sel_Num;
	}
	public void setSel_Num(int sel_Num) {
		Sel_Num = sel_Num;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getSel_Email() {
		return Sel_Email;
	}
	public void setSel_Email(String sel_Email) {
		Sel_Email = sel_Email;
	}
	public int getSel_Regist_Num() {
		return Sel_Regist_Num;
	}
	public void setSel_Regist_Num(int sel_Regist_Num) {
		Sel_Regist_Num = sel_Regist_Num;
	}
	public String getSel_Account() {
		return Sel_Account;
	}
	public void setSel_Account(String sel_Account) {
		Sel_Account = sel_Account;
	}
	
	@Override
	public String toString() {
		return "SellerDTO [Sel_Num=" + Sel_Num + ", Id=" + Id + ", Sel_Email=" + Sel_Email + ", Sel_Regist_Num="
				+ Sel_Regist_Num + ", Sel_Account=" + Sel_Account + "]";
	}
	
}
