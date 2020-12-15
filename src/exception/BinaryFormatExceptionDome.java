package exception;

import java.util.Scanner;

public class BinaryFormatExceptionDome {

	public static void main(String[] args) {
		try {
			Scanner kb=new Scanner(System.in);
			System.out.println("Enter a bin number: ");
			String bin=kb.nextLine();
			System.out.println("The decimal value for bin number "+bin+" is "+binToDecimal(bin));
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public static int binToDecimal(String bin)throws Exception{
		int decimalValue=0;
		for(int i=0;i<bin.length();++i) {
			char binChar=bin.charAt(i);
			decimalValue=decimalValue*2+hexCharToDecimal(binChar);
		}
		return decimalValue;
	}
	public static int hexCharToDecimal(char ch)throws Exception {
		if(ch=='1'||ch=='0')return ch-'0';
		else
			throw new BinaryFormatException("It is not binary");
	}

}
