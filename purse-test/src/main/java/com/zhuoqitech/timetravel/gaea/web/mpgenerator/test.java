package com.zhuoqitech.timetravel.gaea.web.mpgenerator;

/**
 * Created by xiadingli on 2019/10/29.
 */
public class test {


    public static void main(String[] args) {
        String s="abcdef";
        StringBuffer ss=new StringBuffer();
        for(int i=0;i<s.length();i++){
            ss.append(s.charAt(s.length()-1-i));
        }
        System.out.println(ss.toString());
    }
}
