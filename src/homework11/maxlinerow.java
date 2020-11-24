package homework11;
import java.util.Scanner;
import java.util.ArrayList;
public class maxlinerow {

	public static void main(String[] args) {
		System.out.print("Enter the array size n: ");
		Scanner kb=new Scanner(System.in);
		int n=kb.nextInt();
		System.out.println("The random array is");
		int[][] arr=new int[n][n];
		ArrayList<Integer>listrow=new ArrayList<>();
		ArrayList<Integer>listline=new ArrayList<>();
		int maxxrow=-100000;
		int maxxline=-100000;
		int[] cntrow=new int[n];
		int[] cntline=new int[n]; 
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				arr[i][j]=(int)(Math.random()*2);
				System.out.print(arr[i][j]+" ");
				if(arr[i][j]==1) {
					cntrow[i]++;
					if(cntrow[i]>=maxxrow)maxxrow=cntrow[i];
				}
			}
			System.out.println();
		}
		for(int j=0;j<n;++j) {
			for(int i=0;i<n;++i) {
				if(arr[i][j]==1) {
					cntline[j]++;
					if(cntline[i]>=maxxline)maxxline=cntline[i];
				}
			}
		}
///		System.out.println(maxxrow+maxxline);
		for(int i=0;i<n;++i) {
			if(cntrow[i]==maxxrow)listrow.add(i);
			if(cntline[i]==maxxline)listline.add(i);
		}
		for(int i=0;i<listrow.size();++i) {
			int step=(int)listrow.get(i);
			if(i==0)System.out.print("The largest row index: "+step);
			else System.out.print(","+step);
		}
		System.out.println();
		for(int i=0;i<listline.size();++i) {
			int step=(int)listline.get(i);
			if(i==0)System.out.print("The largest column index: "+step);
			else System.out.print(","+step);
		}
//		System.out.println("The largest row index: "+listrow.toString());
//		System.out.println("The largest column index: "+listline.toString());
	}

}
