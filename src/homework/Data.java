package homework;
import java.util.Date;
public class Data {
	public static void main(String[] args) {
//	java.util.Date date = new java.util.Date();
//	System.out.println("The elapsed time since Jan 1, 1970 is "+date.getTime()+" imilliseconds");
//	System.out.println(date.toString());
		Date date=new Date();
		long step=10000;
		int Case=1;
		for(int i=0;i<8;++i) {
			long t=date.getTime();
			t+=step;
			step*=10;
			date.setTime(t);
			System.out.println(Case++ + " "+date.toString());
		}
	}
}