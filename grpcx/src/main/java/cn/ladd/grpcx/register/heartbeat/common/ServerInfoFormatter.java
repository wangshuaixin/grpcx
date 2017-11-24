package cn.ladd.grpcx.register.heartbeat.common;

public class ServerInfoFormatter {
	
	public static String getFormatString(ServerInfo serverInfo)
	{
		return serverInfo.getIp()+":"+serverInfo.getPort();
	}
	
	public static ServerInfo fromFormatString(String formatString)
	{
	    String ip="";
		String port="";
		if(formatString.contains(":"))
		{
			String[] strs=formatString.split(":");
			ip=strs[0];
			port=strs[1];
		}
		return ServerInfo.newBuilder().setIp(ip).setPort(port).build();
	}
}
