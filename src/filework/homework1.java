package filework;
import java.io.*;
public class homework1 {

	public static void main(String[] args)throws IOException {
		try(FileInputStream out=new FileInputStream("D:/Users/������/Desktop/output.txt");
			FileOutputStream in=new FileOutputStream("D:/Users/������/Desktop/input.txt");
		){
			int value;
			int num=0;
			while((value=out.read())!=-1) {
				in.write((byte)value);
				num++;
				System.out.print(value+" ");
			}
			System.out.println("\n"+num+" bytes copied");
		}
	}

}
