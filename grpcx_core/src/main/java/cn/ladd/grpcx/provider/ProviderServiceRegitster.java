package cn.ladd.grpcx.provider;

import java.util.ArrayList;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.register.common.HostInfo;

public class ProviderServiceRegitster {
	
	public static void defaultServiceRegistry()
	{
		ProviderProxy providerProxy=new ProviderProxy(Config.getRegisterIP(), Config.getRegisterPort());
		for(String serviceName:Config.getServiceNameList())
		{
			providerProxy.addService(serviceName, Config.getLocalIP(), String.valueOf(Config.getLocalPortProvider()));
		}
	}
	
	
	public static void addService(String serviceName,HostInfo hostInfo)
	{
		ProviderProxy providerProxy=new ProviderProxy(Config.getRegisterIP(), Config.getRegisterPort());
		ArrayList<String> serviceNames=new ArrayList<String>();
		serviceNames.add(serviceName);
		providerProxy.addService(serviceName, Config.getLocalIP(), String.valueOf(Config.getLocalPortProvider()));
	}
}
