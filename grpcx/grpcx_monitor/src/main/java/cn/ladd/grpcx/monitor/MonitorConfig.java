package cn.ladd.grpcx.monitor;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.ladd.grpcx.config.Config;

@Configuration
public class MonitorConfig {
	
	@Bean
	MonitorProxy getMonitorProxy()
	{
		return new MonitorProxy(Config.getRegisterIP(), Config.getRegisterPort());
	}

}
