package cn.ladd.grpcx.register;

/**
 * 
 * Url info contains host and port
 * @author ladd
 *
 */
public class UrlInfo {
	String host;
	String port;
	
	public UrlInfo(String url)
	{
		if(url.contains(":"))
		{
			String[] strs=url.split(":");
			host=strs[0];
			port=strs[1];
		}
	}
	
	public UrlInfo(String host, String port) {
		super();
		this.host = host;
		this.port = port;
	}

	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return host + ":" + port ;
	}
	
	
	
}
