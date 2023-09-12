package com.itheima.reflect;

import org.junit.Test;

//如果获取Class对象
public class Reflect_ClassTest {

    @Test
    public void test1() {                                             // 1.如果你得到一个类的对象
        User user = new User();
        Class class1 = user.getClass();                               // getClass方法是从Object类中继承
        System.out.println(class1);
    }


    @Test
    public void test2() {                                             // 2.可以直接通过类名获取
        Class clazz = User.class;
        System.out.println(clazz);
    }


    @Test
    public void test3() throws ClassNotFoundException {               // 3.推荐使用的方案
        Class clazz=Class.forName("com.itheima.reflect.User");
        System.out.println(clazz);
    }
}
