package homework;
import java.util.Random;
public class random {

	public static void main(String[] args) {
		Random ran=new Random(1000);
		int step=0;
		for(int i=0;i<50;++i) {
			step=ran.nextInt(100);
			System.out.println(step);
		}
		
	}

}
