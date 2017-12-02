package cn.ladd.grpcx.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Config {
	static Properties properties;
	static String propertiesFileName="config.properties";
	static String DEFAULT_ZOOKEEPER_IP="127.0.0.1";
	static String DEFAULT_ZOOKEEPER_PORT="2181";
	static int DEFAULT_HEARTBEAT_OVERDUE=300;
	static int DEFAULT_HEARTBEAT_INTERVAL=10;
	static int DEFAULT_HEARTBEAT_NODECHECK_INTERVAL=10;
	static String DEFAULT_REGISTER_IP="127.0.0.1";
	static int DEFAULT_REGISTER_PORT=8090;
	static String DEFAULT_LOCAL_IP="127.0.0.1";
	static int DEFAULT_LOCAL_PORT=8094;
	static Logger logger=Logger.getLogger(Config.class);
	static
	{
		properties=new Properties();
		try {
			InputStream inputStream=Config.class.getClassLoader().getResourceAsStream(propertiesFileName);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getZookeeperHost()
	{
		String ip=getValue("zookeeper.ip");
		String port=getValue("zookeeper.port");
		logger.info("Load ip:port is "+ip+":"+port);
		if(ip==null||ip.isEmpty())
		{
			ip=DEFAULT_ZOOKEEPER_IP;
		}
		if(port==null||port.isEmpty())
		{
			port=DEFAULT_ZOOKEEPER_PORT;
		}
		return ip+":"+port;
	}
	
	public  static String getValue(String key)
	{
		return properties.getProperty(key);
	}
	
	public static  int getHeartbeatOverdueSecond()
	{
		String overdueSecond=getValue("heartbeat.overdue.s");
		if(overdueSecond!=null&&!overdueSecond.isEmpty())
		{
			logger.info("overdueSecond is "+overdueSecond);
			return Integer.valueOf(overdueSecond);
		}
		return DEFAULT_HEARTBEAT_OVERDUE;
	}
	
	public static  int getHeartbeatInterval()
	{
		String hearbeatIntervalSecond=getValue("heartbeat.interval.s");
		if(hearbeatIntervalSecond!=null&&!hearbeatIntervalSecond.isEmpty())
		{
			return Integer.valueOf(hearbeatIntervalSecond);
		}
		return DEFAULT_HEARTBEAT_INTERVAL;
	}
	
	public static  int getHeartbeatNodecheckInterval()
	{
		String hearbeatNodecheckIntervalSecond=getValue("heartbeat.nodecheck.interval.s");
		if(hearbeatNodecheckIntervalSecond!=null&&!hearbeatNodecheckIntervalSecond.isEmpty())
		{
			return Integer.valueOf(hearbeatNodecheckIntervalSecond);
		}
		return DEFAULT_HEARTBEAT_NODECHECK_INTERVAL;
	}
	
	public static String getRegisterIP()
	{
		String registerIP=getValue("register.ip");
		if(registerIP!=null&&!registerIP.isEmpty())
		{
			logger.info("registerIP is "+registerIP);
			return registerIP;
		}
		return DEFAULT_REGISTER_IP;
	}
	
	public static int getRegisterPort()
	{
		String registerPort=getValue("register.port");
		if(registerPort!=null&&!registerPort.isEmpty())
		{
			logger.info("registerPort is "+registerPort);
			return Integer.valueOf(registerPort);
		}
		return DEFAULT_REGISTER_PORT;
	}
	
	public static String getLocalIP()
	{
		String localIP=getValue("localhost.ip");
		if(localIP!=null&&!localIP.isEmpty())
		{
			logger.info("localIP is "+localIP);
			return localIP;
		}
		return DEFAULT_LOCAL_IP;
	}
	
	public static int getLocalPort()
	{
		String localPort=getValue("localhost.port");
		if(localPort!=null&&!localPort.isEmpty())
		{
			logger.info("localPort is "+localPort);
			return Integer.valueOf(localPort);
		}
		return DEFAULT_LOCAL_PORT;
	}
	
	public static void main(String[] args) {
		logger.info(getLocalIP());
	}
	
	
}
