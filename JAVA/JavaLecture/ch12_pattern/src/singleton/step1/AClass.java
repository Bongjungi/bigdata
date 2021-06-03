package singleton.step1;

public class AClass {
	private int intVar;
//	private static AClass INSTANCE;
//	public static AClass getInstance() {
//		if(INSTANCE==null) {
//			INSTANCE=new AClass();
//		}
//		return INSTANCE;
//	}
	private static AClass INSTANCE=new AClass();
	public static AClass getInstance() {
		return INSTANCE;
	}
	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
	public int getIntVar() {
		return intVar;
	}

}
