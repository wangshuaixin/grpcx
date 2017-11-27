package cn.ladd.grpcx.provider;

public class ProviderHeartbeatThread extends Thread{
	
	ProviderProxy providerProxy;
	
	public ProviderHeartbeatThread(ProviderProxy providerProxy) {
		// TODO Auto-generated constructor stub
		this.providerProxy=providerProxy;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i!=500;++i) {
			try {
				Thread.sleep(2*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			providerProxy.beat("order", "127.0.0.1", "8094");
		}
	}
}
