package jedisTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class JedisDemo6 {                     //sortedset操作
	Jedis jedis;

	@Before
	public void createJedis() {
		jedis = new Jedis("192.168.19.128");
		jedis.auth("admin");		// 设置密码
	}

	
	@Test
	public void test1() {	              //zadd zrange zrangeByScore
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);

		Set<String> set = jedis.zrange("zkey", 0, -1);
		System.out.println(set);
		// 根据分数获取
		Set<String> set1 = jedis.zrangeByScore("zkey", 70.0, 90.0);
		System.out.println(set1);
	}


	@Test
	public void test2() {	              //获取分数元素 zrangeWithScores
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);

		Set<Tuple> zws = jedis.zrangeWithScores("zkey", 0, -1);
		for (Tuple t : zws) {
			System.out.println(t.getScore() + "  " + t.getElement());
		}
	}


	@Test
	public void test3() {	              //zrank
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);

		Long num = jedis.zrank("zkey", "赵六");
		System.out.println(num);
	}


	@Test
	public void test4() {	              //zscore
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);
		Double zscore = jedis.zscore("zkey", "张三");
		System.out.println(zscore);
	}


	@Test
	public void test5() {	              //zrem
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);

		jedis.zrem("zkey", "李四");
		
		Set<Tuple> zws = jedis.zrangeWithScores("zkey", 0, -1);
		for (Tuple t : zws) {
			System.out.println(t.getScore() + "  " + t.getElement());
		}
	}

}
