package cn.ladd.grpcx.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Monitor {
	
	public static void main(String[] args) {
		
		SysInfoMonitorThread sysInfoMonitorThread=new SysInfoMonitorThread();
		sysInfoMonitorThread.start();
		
		SpringApplication.run(Monitor.class, args);
	}

}
