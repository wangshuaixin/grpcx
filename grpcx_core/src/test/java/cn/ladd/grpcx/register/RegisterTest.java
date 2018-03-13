package cn.ladd.grpcx.register;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import cn.ladd.grpcx.register.common.HostInfo;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegisterTest {
	HostInfo calHostInfo;
	HostInfo playHostInfo;
	@Before
	public void setUp()
	{
		Register.clearAllProviderAndConsumer();
		calHostInfo=HostInfo.newBuilder()
								.setIp("192.168.0.1")
								.setPort("8090")
								.build();
		playHostInfo=HostInfo.newBuilder()
								.setIp("192.168.0.1")
								.setPort("8091")
								.build();
	}

	@Test
	public void testAddService() {
		Register.addService("cal", calHostInfo);
		Register.addService("play", playHostInfo);
		assertTrue(calHostInfo.equals(Register.lookup("cal").get(0)));
		assertTrue(playHostInfo.equals(Register.lookup("play").get(0)));
	}
	
	
	@Test
	public void testRemoveService() {
		Register.removeService("cal", calHostInfo);
		Register.removeService("play", playHostInfo);
		assertTrue(Register.lookup("cal").isEmpty());
		assertTrue(Register.lookup("play").isEmpty());
	}

}
