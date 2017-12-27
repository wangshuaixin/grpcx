package cn.ladd.grpcx.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.ladd.grpcx.sensor.BaseThread;

@SpringBootApplication
public class MonitorThead extends BaseThread{
	public MonitorThead() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		SysInfoMonitorThread sysInfoMonitorThread=new SysInfoMonitorThread();
		sysInfoMonitorThread.start();
		String[] args=new String[0];
		SpringApplication.run(MonitorThead.class,args);
		
		
	}
}
