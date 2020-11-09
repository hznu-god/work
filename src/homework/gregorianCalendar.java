package homework;
import java.util.GregorianCalendar;
public class gregorianCalendar {

	public static void main(String[] args) {
		GregorianCalendar Gre=new GregorianCalendar();
		long year=Gre.get(GregorianCalendar.YEAR);
		long month=Gre.get(GregorianCalendar.MONTH);
		long day=Gre.get(GregorianCalendar.DAY_OF_MONTH);
		System.out.println(year+" "+month+" "+day);
		Gre.setTimeInMillis(1234567898765L);
		System.out.println(Gre.getTime());
	}

}
