package singleton.step1;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE;
	public static SingletonClass getInstance() {
		// 생성된 객체가 없으면 SingletonClass형 객체를 생성하여 주소를 return
		// 생성된 객체가 있을 경우 그 객체의 주소를 return
		if(INSTANCE==null) { 
			INSTANCE=new SingletonClass(); //INSTANCE에 주소값이 들어있다.
		}
		return INSTANCE;
	}
	private SingletonClass(){}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
