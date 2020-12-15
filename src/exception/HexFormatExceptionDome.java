package exception;
import java.util.Scanner;
public class HexFormatExceptionDome {

	public static void main(String[] args) {
		try {
			Scanner kb=new Scanner(System.in);
			System.out.println("Enter a hex number: ");
			String hex=kb.nextLine();
			System.out.println("The decimal value for hex number "+hex+" is "+hexToDecimal(hex.toUpperCase()));
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public static int hexToDecimal(String hex)throws Exception{
		int decimalValue=0;
		for(int i=0;i<hex.length();++i) {
			char hexChar=hex.charAt(i);
			decimalValue=decimalValue*16+hexCharToDecimal(hexChar);
		}
		return decimalValue;
	}
	public static int hexCharToDecimal(char ch)throws Exception {
		if(ch>='A'&&ch<='F')return 10+ch-'A';
		else if(ch<'0'||ch>'9'&&ch<'a'||ch>'z')
			throw new HexFormatException("It is not hex");
		else return ch-'0';
	}


}
