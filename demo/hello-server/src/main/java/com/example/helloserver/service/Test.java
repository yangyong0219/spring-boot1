package com.example.helloserver.service;

import org.springframework.util.StringUtils;

import javax.jnlp.IntegrationService;
import java.util.*;

public class Test {
    private static final Map<Character, Integer> unit = new HashMap<>();

    static {
        unit.put('M', 1);
        unit.put('G', 1024);
        unit.put('T', 1024);
    }

    public static void main(String[] args) {

        int[] dataM = new int[3];
        String[] originalData = new String[3];
        originalData[0] = "2G4M";
        originalData[1] = "3M2G";
        originalData[2] = "1T";
        dataM[0] = (convertToM("2G4M"));
        dataM[1] = (convertToM("3M2G"));
        dataM[2] = (convertToM("1T"));
        for (int j = 0; j < dataM.length; j++) {
            for (int k = 0; k < dataM.length; k++) {
                boolean min = true;
                for (int i = 0; i < dataM.length; i++) {
                    if (dataM[k] > dataM[i]) {
                        min = false;
                        break;
                    }
                }
                if (min) {
                    System.out.println(originalData[k]);
                    dataM[k] = Integer.MAX_VALUE;
                    break;
                }
            }
        }

    }


    private static int convertToM(String s) {
        int total = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                sb.append(c);
            } else {
                //说明C是一个字符，需要获取
                Integer integer = unit.get(c);
                total = total + Integer.parseInt(sb.toString()) * integer;
                sb.delete(0, sb.length());
            }
        }
        return total;
    }

}
