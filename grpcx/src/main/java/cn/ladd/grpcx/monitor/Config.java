package cn.ladd.grpcx.monitor;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
	MonitorProxy getMonitorProxy()
	{
		return new MonitorProxy("127.0.0.1", 8090);
	}

}
