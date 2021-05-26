package singleton.step2;

public class SingletonClass {
	private static SingletonClass INSTANCE;// = new SingletonClass();
	private int i;
	private SingletonClass() {
		i=10;
	}
	public static SingletonClass getInstance() { //public하게 static하게 SingletonClass를 가져온다. getInstance로
		if(INSTANCE==null) {
			INSTANCE=new SingletonClass();
		}
		return INSTANCE;
		
	}
	public int getI() {
		return i;
	}public void setI(int i) {
		this.i = i;
	}
}
