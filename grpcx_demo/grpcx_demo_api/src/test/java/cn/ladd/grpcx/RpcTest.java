package cn.ladd.grpcx;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.ladd.grpcx.consumer.ChannelFactory;
import cn.ladd.grpcx.consumer.ConsumerBootstrap;
import cn.ladd.grpcx.monitor.MonitorThead;
import cn.ladd.grpcx.register.Register;
import cn.ladd.grpcx.register.demo.add.AddGrpc;
import cn.ladd.grpcx.register.demo.add.ProviderDemoThread;
import cn.ladd.grpcx.register.demo.add.RequestInfo;
import cn.ladd.grpcx.register.demo.add.AddGrpc.AddBlockingStub;
import cn.ladd.grpcx.register.server.RegisterServerThread;

public class RpcTest {
	
	private static Logger logger=Logger.getLogger(RpcTest.class);
	RegisterServerThread registerServerThread;
	MonitorThead monitorThead;
	ProviderDemoThread providerDemoThread;
	
	@Before
	public void init()
	{
		
		try {
			Register.clearAllProviderAndConsumer();
			registerServerThread=new RegisterServerThread();
			registerServerThread.start();
			Thread.sleep(10*1000);
			logger.info("Registor started!");
			
			monitorThead=new MonitorThead();
			monitorThead.start();
			Thread.sleep(10*1000);
			logger.info("Monitor started!");
			
			providerDemoThread=new ProviderDemoThread();
			providerDemoThread.start();
			Thread.sleep(10*1000);
			logger.info("Provider started!");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	
	@Test
	public void test() {
		
		ConsumerBootstrap.init();
		
		
		AddBlockingStub addBlockingStub=AddGrpc.newBlockingStub(ChannelFactory.getChannel("cal"));
		RequestInfo requestInfo=RequestInfo.newBuilder()
				.setA(1)
				.setB(3)
				.build();
		int result=addBlockingStub.add(requestInfo).getC();
		logger.info("Result from remote of 1+3="+result);
		assertTrue(result==4);
		
	}
	
	@After
	public void clear()
	{
		registerServerThread.stopCurrentThread();
		monitorThead.stopCurrentThread();
		providerDemoThread.stopCurrentThread();
		
	}

}
