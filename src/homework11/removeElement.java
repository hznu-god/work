package homework11;
import java.util.Scanner;
import java.util.ArrayList;
public class removeElement {
	public static void removeDuplicate(ArrayList<Integer>list) {
		for(int i=0;i<list.size();++i) {
			int step=list.get(i);
			while(list.lastIndexOf(step)!=i&&list.lastIndexOf(step)!=-1) {
				list.remove(list.lastIndexOf(step));
			}
		}
	}
	public static void main(String[] args) {
		System.out.print("Enter 10 integers: ");
		Scanner kb=new Scanner(System.in);
		ArrayList<Integer>list=new ArrayList<>();
		for(int i=0;i<10;++i) {
			list.add(kb.nextInt());
		}
		System.out.print("The distinct integers are ");
		removeDuplicate(list);
		for(int i=0;i<list.size();++i) {
			System.out.print(list.get(i)+" ");
		}
	}

}
