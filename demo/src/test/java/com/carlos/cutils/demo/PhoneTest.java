package com.carlos.cutils.demo;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by Carlos on 2019-05-21.
 */
public class PhoneTest {


    @Test
    public void test() {
        String phone = "12334434343434434";
        System.out.println(isPhoneNumber(phone));
    }

    public static boolean isPhoneNumber(String input) {// 判断手机号码是否规则
        String regex = "(1[0-9][0-9]|15[0-9]|18[0-9])\\d{8}";
        Pattern p = Pattern.compile(regex);
        return p.matches(regex, input);//如果不是号码，则返回false，是号码则返回true

    }
}
