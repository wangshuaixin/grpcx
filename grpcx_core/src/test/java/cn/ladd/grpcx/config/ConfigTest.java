package cn.ladd.grpcx.config;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigTest {

	@Test
	public void test() {
		assertTrue(Config.DEFAULT_HEARTBEAT_INTERVAL==Config.getHeartbeatInterval());
		assertTrue(Config.DEFAULT_HEARTBEAT_NODECHECK_INTERVAL==Config.getHeartbeatNodecheckInterval());
		assertTrue(Config.DEFAULT_HEARTBEAT_OVERDUE==Config.getHeartbeatOverdueSecond());
		assertTrue(Config.DEFAULT_LOCAL_IP.equals(Config.getLocalIP()));
		assertTrue(Config.DEFAULT_REGISTER_IP.equals(Config.getRegisterIP()));
		assertTrue(Config.DEFAULT_REGISTER_PORT==Config.getRegisterPort());
		assertTrue((Config.DEFAULT_ZOOKEEPER_IP+":"+Config.DEFAULT_ZOOKEEPER_PORT).equals(Config.getZookeeperHost()));
		
	}

}
