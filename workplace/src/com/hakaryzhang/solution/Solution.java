package com.hakaryzhang.solution;

import java.lang.reflect.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Integer n = 1;
        Integer n1 = n;
        n = null;
        System.out.println(n);
        System.out.println(n1);
    }

}


