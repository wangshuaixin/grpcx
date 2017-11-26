package cn.ladd.grpcx.provider;

public class Provider {
	public static void main(String[] args) throws InterruptedException {
		ProviderProxy heartbeatClientProxy=new ProviderProxy("127.0.0.1", 8090);
		heartbeatClientProxy.addService("order", "127.0.0.1", "8094");
		for(int i=0;i!=50;++i) {
				Thread.sleep(2*1000);
				heartbeatClientProxy.beat("order", "127.0.0.1", "8094");
		}
		heartbeatClientProxy.shutdown();
		
	}
}
