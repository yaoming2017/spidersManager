package com.sicdlib.util.MD5Util;

import java.util.Random;

/**
 * Created by DeMH on 2017/4/24.
 */
public class RandNumUtil {
    public static String getRandNum(int num){
        String randnum = "";
        for (int i = 0;i < num;i++){
            Random rand = new Random();
            randnum += rand.nextInt(10);
        }

        return randnum;
    }

    public static void main(String args[]) {
        String random = getRandNum(6);
        System.out.println("Hello World!"+random);

    }
}
