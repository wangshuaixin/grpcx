package cn.ladd.grpcx.register.heartbeat.client;

public class HeartbeatClient {
	public static void main(String[] args) throws InterruptedException {
		HeartbeatClientProxy heartbeatClientProxy=new HeartbeatClientProxy("127.0.0.1", 8090);
		for(int i=0;i!=1000;++i) {
				Thread.sleep(2*1000);
				heartbeatClientProxy.beat("add", "192.168.0.0", "80");
		}
		heartbeatClientProxy.shutdown();
		
	}
}
