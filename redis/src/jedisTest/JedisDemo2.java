package jedisTest;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisDemo2 {      //string操作
	Jedis jedis;

	@Before
	public void createJedis() {
		jedis = new Jedis("192.168.19.128");
		jedis.auth("admin");		// 设置密码
	}

	@Test
	public void test1() {    	//set get
		jedis.set("username", "tom");		
		String value = jedis.get("username");
		System.out.println(value);
	}
	

	@Test
	public void test2(){     	//mset  mget
		jedis.mset("password","123","age","20");
		
		List<String> values = jedis.mget("username","password","age");
		
		System.out.println(values);
	}
	

	@Test
	public void test3(){	    //append  setrange  getrange
		//jedis.append("username"," is boy");
		//jedis.setrange("username", 7,"girl");
		System.out.println(jedis.get("username"));
		
		System.out.println(jedis.getrange("username", 7, -1));
	}

}
