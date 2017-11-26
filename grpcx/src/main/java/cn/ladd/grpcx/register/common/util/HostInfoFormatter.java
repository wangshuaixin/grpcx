package cn.ladd.grpcx.register.common.util;

import cn.ladd.grpcx.register.common.HostInfo;

public class HostInfoFormatter {
	
	public static String getFormatString(HostInfo hostInfo)
	{
		return hostInfo.getIp()+":"+hostInfo.getPort();
	}
	
	public static HostInfo fromFormatString(String formatString)
	{
	    String ip="";
		String port="";
		if(formatString.contains(":"))
		{
			String[] strs=formatString.split(":");
			ip=strs[0];
			port=strs[1];
		}
		return HostInfo.newBuilder().setIp(ip).setPort(port).build();
	}
}
