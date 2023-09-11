package redis.src.jedisTest;

public class JedisDemo3 {

    Jedis jedis;

    publice void createJedis(){
        jedis = new Jedis("193.168.19.218");

        jedis.auth("admin");
    }

    public void test1(){
        jedis.lpush("names","tom","james","张三","李四");
        List<String> names = jedis.lrange("name",0,-1);
        System.out.println(names);
    }

    public void test2(){
        String value = jedis.lindex("names",1);
        System.out.println(value);
    }

    public void test3(){
        jedis.linsert("names",LIST_POSITION.BEFORE,"james","fox");

        List<String> names = jedis.lrange("names",0,-1);
        System.out.println(names);
    }

    public void test4(){
        jedis.lrem("names",1,"tom");
        List<String> names = jedis.lrange("name",0,-1);
        System.out.println(names);
    }
}
