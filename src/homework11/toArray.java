package homework11;
import java.util.Scanner;
import java.util.ArrayList;
public class toArray {
	public static ArrayList<Character>toCharacterArray(String s){
		ArrayList<Character>list=new ArrayList<>();
		for(int i=0;i<s.length();++i) {
			Character ch=s.charAt(i);
			list.add(ch);
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.print("Enter a String :");
		String s;
		Scanner kb=new Scanner(System.in);
		s=kb.next();
//		System.out.println(s);
		ArrayList<Character>list=new ArrayList<>();
		list=toCharacterArray(s);
		System.out.println("The list is: "+list.toString());
	}

}
