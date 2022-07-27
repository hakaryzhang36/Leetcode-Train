#include<iostream>
#include<string>
using namespace std;

class Solution {
   public:
    string intToRoman(int num) {
        string str = "";
        if(num >= 900){
            while(num > 1000){
                str += "M";
                num -= 1000;
            }
            if(num >= 900){
                str += "CM";
                num -= 900;
            }
        }
        if(num < 1000 && num >= 500){
            str += "D";
            num -= 500;
            while(num >= 100){
                str += "C";
                num -= 100;
            }
        }
        if(num < 500 && num > 400){
            str += "CD";
            num -= 400;
        }
        if(num < 400 && num >= 100){
            while(num >= 100){
                str += "C";
                num -= 100;
            }
        }
        if(num < 100 && num >= 50){
            str += "L";
            num -= 50;
            while(num > 10){
                str += "X";
                num -= 10;
            }
        }
        if(num < 50 && num >= 40){
            str += "XL";
            num -= 40;
        }
        if(num < 40 && num >= 10){
            while(num >= 10){
                str += "X";
                num -= 10;
            }
        }
        if(num < 10 && num >= 5){
            str += "V";
            num -= 5;
            while(num > 0){
                str += "I";
                num -= 1;
            }
        }
        if(num = 4){
            str += "IV";
            return str;
        }
        if(num < 4){
            while(num > 0){
                str += "I";
                num -= 1;
            }
            return str;
        }
    }
};