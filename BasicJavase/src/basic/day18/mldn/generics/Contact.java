package basic.day18.mldn.generics;

public class Contact implements Info9{//ʵ��Info9�ӿ�
	private String address;//��ϵ��ַ
	private String telphone;//��ϵ��ʽ
	private String zipcode;//��������
	public Contact(String address, String telphone, String zipcode) {
		this.setAddress(address);
		this.setTelphone(telphone);
		this.setZipcode(zipcode);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "��ϵ��ʽ��"+"\n"+
		"\t|-��ϵ�绰��"+this.telphone+"\n"+
		"\t|-��ϵ��ַ��"+this.address+"\n"+
		"\t|-�������룺"+this.zipcode;//���ص���Ϣ
	}
	
}
