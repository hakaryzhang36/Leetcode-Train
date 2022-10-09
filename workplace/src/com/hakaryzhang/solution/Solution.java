package com.hakaryzhang.solution;

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

    // Leetcode 242-valid-anagram
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            }
            else {
                map.replace(ch, map.get(ch) + 1);
            }
        }

        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            else {
                map.replace(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }

        return map.size() == 0;

    }

}
