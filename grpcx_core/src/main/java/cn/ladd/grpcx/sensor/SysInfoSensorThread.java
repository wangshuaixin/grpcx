package cn.ladd.grpcx.sensor;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.consumer.LoadBalance;
import cn.ladd.grpcx.monitor.MonitorGrpc;
import cn.ladd.grpcx.monitor.MonitorGrpc.MonitorBlockingStub;
import cn.ladd.grpcx.monitor.ServiceInfo;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.RegisterGrpc;
import cn.ladd.grpcx.register.common.RegisterGrpc.RegisterBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SysInfoSensorThread extends BaseThread{
	ManagedChannel channel;
	MonitorBlockingStub monitorBlockingStub;
	public SysInfoSensorThread() {
		// TODO Auto-generated constructor stub
		super();
		HostInfo sysInfoProviderInfo=LoadBalance.getHostInfo("monitor");
		channel=ManagedChannelBuilder.forAddress(sysInfoProviderInfo.getIp(), Integer.valueOf(sysInfoProviderInfo.getPort()))
					.usePlaintext(true)
					.build();
		monitorBlockingStub=MonitorGrpc.newBlockingStub(channel);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!this.stopped)
		{
			try {
				Thread.sleep(Config.getHeartbeatInterval()*1000);
				ServiceInfo serviceInfo=GetSysInfoUtil.getServiceInfo();
				monitorBlockingStub.sendSysInfo(serviceInfo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
