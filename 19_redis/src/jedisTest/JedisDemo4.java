package jedisTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;


public class JedisDemo4 {                     //hash操作
	Jedis jedis;

	@Before
	public void createJedis() {
		jedis = new Jedis("192.168.19.128");
		jedis.auth("admin");          //设置密码
	}


	@Test
	public void test1() {	              //hset hget
		jedis.hset("user", "username", "tom");

		String value = jedis.hget("user", "username");
		System.out.println(value);
	}


	@Test
	public void test2() {	              //hmset hmget
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("password", "123");
		hash.put("sex", "male");
		jedis.hmset("user", hash);

		List<String> values = jedis.hmget("user", "username", "password", "sex");
		System.out.println(values);
	}
	

	@Test
	public void test3(){	              //hgetall hkeys  kvals
		Map<String, String> map = jedis.hgetAll("user");
		for(String key:map.keySet()){
			System.out.println(key+"  "+map.get(key));
		}
		
		Set<String> keys = jedis.hkeys("user");
		System.out.println(keys);
		
		List<String> values = jedis.hvals("user");
		System.out.println(values);
	}
	

	@Test
	public void test4(){	              //hdel
		jedis.hdel("user", "username","password");
		Map<String, String> map = jedis.hgetAll("user");
		for(String key:map.keySet()){
			System.out.println(key+"  "+map.get(key));
		}
	}
}
