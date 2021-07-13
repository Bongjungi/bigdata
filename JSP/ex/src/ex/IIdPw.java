package ex;

public interface IIdPw {
	int idConfirm(String id);
	int login(String id, String pw);
	String pwget(String id);
	int idpwinsert(String id, String pw, String tel, String address, String gender, String email);
	String chChar(int e, int n, String str);
}
