package homework11;
import java.util.Scanner;
class point{
	double x,y;
}
public class convexPolygonArea {
	public static void main(String[] args) {
		System.out.print("Enter the number of points: ");
		Scanner kb=new Scanner(System.in);
		int n=kb.nextInt();
		System.out.println("Enter the coordinates of the points: ");
		point[] arr=new point[n+1];
		for(int i=1;i<=n;++i) {
			arr[i]=new point();
		}
		for(int i=1;i<=n;++i) {
			arr[i].x=kb.nextDouble();
			arr[i].y=kb.nextDouble();
			System.out.print(arr[i].x+" "+arr[i].y+" ");
		}
		System.out.println();
		double ans1=0;
		double ans2=0;
		for(int i=1;i<=n;++i) {
			if(i==n) {
				ans1+=arr[i].x*arr[(i+1)%n].y;
				ans2+=arr[i].y*arr[(i+1)%n].x;
			}
			else {
				ans1+=arr[i].x*arr[i+1].y;
				ans2+=arr[i].y*arr[i+1].x;
			}
		}
		double ans=0.5*Math.abs(ans1-ans2);
		System.out.println("The total area is "+ans);
	}
}
