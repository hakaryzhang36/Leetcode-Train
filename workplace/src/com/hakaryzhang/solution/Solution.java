package com.hakaryzhang.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.map.put('a', 1);
        Solution s2 = s;
        s2.map.replace('a', 2);
        System.out.println(map.get('a'));
        System.out.println(mapClone.get('a'));
    }

    int i = 1;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

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
