package cn.ladd.grpcx.monitor;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ladd.grpcx.register.common.HostInfo;

@Controller
public class MonitorController {
	
	@Autowired
	MonitorProxy monitorProxy;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public @ResponseBody ArrayList<String> index()
	{
		return monitorProxy.getAllServiceNames();
	}
	
	@RequestMapping(value="/{serviceName}",method=RequestMethod.GET)
	public @ResponseBody ArrayList<String> lookup(@PathVariable("serviceName") String serviceName)
	{
		return monitorProxy.lookup(serviceName);
	}

}
