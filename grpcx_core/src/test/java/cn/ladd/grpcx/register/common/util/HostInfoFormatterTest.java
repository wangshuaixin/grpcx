package cn.ladd.grpcx.register.common.util;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.ladd.grpcx.register.common.HostInfo;

public class HostInfoFormatterTest {

	@Test
	public void testGetFormatString() {
		HostInfo hostInfo=HostInfo.newBuilder()
								.setIp("127.0.0.1")
								.setPort("8080")
								.build();
		assertTrue("127.0.0.1:8080".equals(HostInfoFormatter.getFormatString(hostInfo)));
	}
	
	@Test
	public void testFromFormatString() {
		HostInfo hostInfo=HostInfo.newBuilder()
								.setIp("127.0.0.1")
								.setPort("8080")
								.build();
		assertTrue(hostInfo.equals(HostInfoFormatter.fromFormatString("127.0.0.1:8080")));
	}

}
