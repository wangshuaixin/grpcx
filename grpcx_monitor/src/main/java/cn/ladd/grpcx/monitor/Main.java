package cn.ladd.grpcx.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
public class Main {
	
	
	
	public static void main(String[] args) {
		MonitorThead monitorThead=new MonitorThead();
		monitorThead.start();
		
		
//		SysInfoMonitorThread sysInfoMonitorThread=new SysInfoMonitorThread();
//		sysInfoMonitorThread.start();
//		
//		SpringApplication.run(Monitor.class, args);
	}

}
