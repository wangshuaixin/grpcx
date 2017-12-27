package cn.ladd.grpcx;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cn.ladd.grpcx.monitor.MonitorThead;
import cn.ladd.grpcx.register.Register;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.server.RegisterServerThread;

public class RPCTest {

	//TODO need to resolve port conflict
//	@Before
//	public void setUp()
//	{
//		Register.clearAllProviderAndConsumer();
//		try {
//			new RegisterServerThread().start();
//			Thread.sleep(5*1000);
//			new MonitorThead().start();
//			Thread.sleep(10*1000);
//			new ProviderDemoThread().start();
//			Thread.sleep(5*1000);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
