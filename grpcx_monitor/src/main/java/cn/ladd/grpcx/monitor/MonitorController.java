package cn.ladd.grpcx.monitor;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.ladd.grpcx.register.common.HostInfo;

@RestController
public class MonitorController {
	
	@Autowired
	MonitorProxy monitorProxy;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public ArrayList<String> index()
	{
		return monitorProxy.getAllServiceNames();
	}
	
	@RequestMapping(value="/{serviceName}",method=RequestMethod.GET)
	public ServiceSummary lookup(@PathVariable("serviceName") String serviceName)
	{
		
		ServiceSummary serviceSummary=new ServiceSummary();
		serviceSummary.setServiceName(serviceName);
		serviceSummary.setProviderHostInfos(monitorProxy.lookup(serviceName));
		serviceSummary.setConsumerHostInfos(monitorProxy.getConsumerHostInfos(serviceName));
		return serviceSummary;
	}

}
