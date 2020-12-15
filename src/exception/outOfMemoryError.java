package exception;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class outOfMemoryError {

	public static void main(String[] args) {
		List list=new ArrayList();
    	try {
			while(true) {
				list.add(new Object());
			}
		} catch (OutOfMemoryError e) {
			System.out.println("Catch!");
			System.exit(0);
		}
	}

}
