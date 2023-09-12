package jedisTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;

//list操作
public class JedisDemo3 {
	Jedis jedis;

	@Before
	public void createJedis() {
		jedis = new Jedis("192.168.19.128");
		jedis.auth("admin");	                  // 设置密码
	}

	
	@Test
	public void test1() {	                           //lpush lrange
		jedis.lpush("names", "tom", "james", "张三", "李四");
		List<String> names = jedis.lrange("names", 0, -1);
		System.out.println(names);
	}


	@Test
	public void test2() {	                           // lset
		// jedis.lset("names", 1, "王五");
		// List<String> names = jedis.lrange("names", 0, -1);
		// System.out.println(names);

		String value = jedis.lindex("names", 1);
		System.out.println(value);
	}


	@Test
	public void test3() {	                           // linsert
		jedis.linsert("names", LIST_POSITION.BEFORE, "james", "fox");

		List<String> names = jedis.lrange("names", 0, -1);
		System.out.println(names);
	}
	

	@Test
	public void test4(){	                           // lrem
		jedis.lrem("names", 1, "tom");
		List<String> names = jedis.lrange("names", 0, -1);
		System.out.println(names);
		
		
	}

}
