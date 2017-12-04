package cn.ladd.grpcx.monitor;

import java.util.ArrayList;

import cn.ladd.grpcx.register.common.HostInfo;

public class ServiceSummary {
	
	String serviceName;
	ArrayList<String> consumerHostInfos;
	ArrayList<String> providerHostInfos;
	
	public ServiceSummary() {
		// TODO Auto-generated constructor stub
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public ArrayList<String> getConsumerHostInfos() {
		return consumerHostInfos;
	}
	public void setConsumerHostInfos(ArrayList<String> consumerHostInfos) {
		this.consumerHostInfos = consumerHostInfos;
	}
	public ArrayList<String> getProviderHostInfos() {
		return providerHostInfos;
	}
	public void setProviderHostInfos(ArrayList<String> providerHostInfos) {
		this.providerHostInfos = providerHostInfos;
	}
	
	

}
