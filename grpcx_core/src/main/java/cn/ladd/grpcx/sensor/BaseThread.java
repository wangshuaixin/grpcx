package cn.ladd.grpcx.sensor;

public class BaseThread extends Thread{
	protected boolean stopped;
	
	public BaseThread() {
		// TODO Auto-generated constructor stub
		this.stopped=false;
	}
	
	public void stopCurrentThread()
	{
		this.stopped=true;
	}

}
