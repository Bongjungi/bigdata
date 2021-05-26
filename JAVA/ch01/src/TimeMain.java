import java.util.Date;

public class TimeMain {
	public static void main(String[] args) {
		
		long time =System.currentTimeMillis();
		Date date = new Date(time);//Date date = new Date();
		System.out.println(date);
	}
}
