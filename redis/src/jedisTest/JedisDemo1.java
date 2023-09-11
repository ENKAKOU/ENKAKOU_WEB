package jedisTest;

import redis.clients.jedis.Jedis;

public class JedisDemo1 {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.19.128");

		jedis.auth("admin");		//设置密码
		jedis.set("foo", "bar");
		
		String value = jedis.get("foo");
		System.out.println(value);
	}
}
