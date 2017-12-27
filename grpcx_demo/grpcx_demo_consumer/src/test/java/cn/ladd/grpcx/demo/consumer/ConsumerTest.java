package cn.ladd.grpcx.demo.consumer;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.ladd.grpcx.config.Config;

public class ConsumerTest {

	@Test
	public void test() {
		assertTrue(Config.getRefServiceNameList().contains("cal"));
	}

}
