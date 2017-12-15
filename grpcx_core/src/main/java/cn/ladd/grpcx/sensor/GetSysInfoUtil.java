package cn.ladd.grpcx.sensor;

import java.util.Arrays;

import cn.ladd.grpcx.monitor.ServiceInfo;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.NetworkParams;

public class GetSysInfoUtil {
	public static void main(String[] args) {
		
	}
	
	public static ServiceInfo getServiceInfo()
	{
		SystemInfo si = new SystemInfo();
		HardwareAbstractionLayer hal = si.getHardware();
		ServiceInfo serviceInfo=ServiceInfo.newBuilder()
								.setHostName(si.getOperatingSystem().getNetworkParams().getHostName())
								.setTotalRam(String.valueOf(si.getHardware().getMemory().getAvailable()))
								.build();
		return serviceInfo;
	}
	
    
}
