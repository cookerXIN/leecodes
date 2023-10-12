package com.liao.paperTest.huawei.h1011;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/10/11
 */
public class Test3 {
    public static void main(String[] args) {

    }

    static class Save {
        Map<BigInteger, String> map = new HashMap<>();

        public void write(String address, int len, String data) {
            BigInteger bigHex = new BigInteger(address, 16);
            for (int i = 0; i < len; i++) {

            }
        }
    }
}
