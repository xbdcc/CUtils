package com.carlos.cutils.demo;

import org.junit.Test;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Created by Carlos on 2019-05-21.
 */
public class PhoneTest {


    @Test
    public void test() {
//        String phone = "12334434343434434";
//        System.out.println(isPhoneNumber(phone));

        int i =3;
        System.out.println((i++)+(i++)+(++i));

//        String a =new String("abc ");
//        String b =a.trim();
//        String c =b.intern();
//        System.out.println(c==b);
//
//        File f = new File(this.getClass().getResource("/").getPath());
//        System.out.println(f);
//        getFiles(f.getPath());
    }

    public static boolean isPhoneNumber(String input) {// 判断手机号码是否规则
        String regex = "(1[0-9][0-9]|15[0-9]|18[0-9])\\d{8}";
        Pattern p = Pattern.compile(regex);
        return p.matches(regex, input);//如果不是号码，则返回false，是号码则返回true

    }

    public void getFiles(String path) {
        File file = new File(path);
        if (!file.exists()) return;
        for (String sfilePath : file.list()) {
            System.out.println("file path:" + sfilePath);
            File file1 = new File(sfilePath);
            if (file1.exists())
                getFiles(sfilePath);
        }
    }


}
