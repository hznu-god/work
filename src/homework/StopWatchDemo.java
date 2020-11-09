package homework;
import java.util.Date;
public class StopWatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopWatch time=new StopWatch();
//		System.out.println(time.getStartTime());
		int[] a=new int[100000];
		for(int i=0;i<100000;++i) {
			a[i]=(int)Math.random()*100000;
		}
//		Date d=new Date();
//		System.out.println(d.getTime());
		time.start();
//		System.out.println(time.getStartTime());
		for(int i=0;i<100000;++i) {
			int pos=i;
			for(int j=i+1;j<100000;++j) {
				if(a[j]<a[pos]) {
					pos=j;
				}
			}
			int temp=a[i];
			a[i]=a[pos];
			a[pos]=temp;
		}
		time.stop();
//		Date d1=new Date();
//		System.out.println(d1.getTime());
//		System.out.println(time.getEndTime());
		long pass=time.getElapsedTime();
		System.out.println(pass);
	}

}
