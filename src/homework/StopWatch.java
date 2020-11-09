package homework;
import java.util.Date;
public class StopWatch {
	private long startTime;
	private long endTime;
	private long currentTime(){
        Date date = new Date();
        return date.getTime();
    }
	public StopWatch() {
		this.startTime=0;
        this.endTime=0;
    }
	public long getStartTime() {
		return startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void start() {
		startTime=currentTime();
	}
	public void stop() {
		endTime=currentTime();
	}
	public long getElapsedTime() {
		return endTime-startTime;
	}
}
