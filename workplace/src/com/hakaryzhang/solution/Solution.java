package com.hakaryzhang.solution;

import java.lang.reflect.*;
import java.util.*;

public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution s1 = new Solution();
        s1.i = 1;
        s1.list.add(1);

        // 复制
        Solution s2 = (Solution) s1.clone();
        s2.i = 2;
        s2.list.add(2);

        // 两个不同的对象
        System.out.println(s1 == s2);   // false

        // 基本数据类型是深复制
        System.out.println(s1.i);       // 2
        System.out.println(s2.i);       // 2

        // 引用类型是浅复制
        System.out.println(s1.list);    // [1, 2]
        System.out.println(s2.list);    // [1, 2]

        System.out.println("------------------");

        Solution s = new Child();
        System.out.println(s.getClass());
        s.func();

        List<Integer> list = new ArrayList<Integer>();

        // dynamic proxy
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class }, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
    }

    public Solution func() {
        return this;
    }


    int i;
    List<Integer> list = new ArrayList<Integer>();


    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    char c = new String().charAt(1);
}

class Child extends Solution {
    @Override
    public void func() {
        super.func();
        System.out.println("Child's func()");
    }
}

interface Hello {
    void morning(String name);
}
