package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

//验证IP地址
public class Q468 {
    public static void main(String[] args) {
        Q468 q = new Q468();
        String IP = "172.16.254.1.";
        System.out.println(q.validIPAddress(IP));
    }
    //9ms 62%
    //使用split将字符串分割开，然后判断每个小段是否符合条件
    //注意split分割时"."需要转义"\\." 而startwith,endwith时"."不需要转义
    //split再分割时如果分割点在最后，不会分割出空字符串，如"1:".split(":") 分割出来的只有"1" ,没有""
    //判断IPv4时，可以将其转换为int判断，如果转换出现异常，return "Neither"
    public String validIPAddress(String IP) {
        if(IP.length()==0) return "Neither";


        if(IP.contains(":")){
            if(IP.endsWith(":")) return "Neither";
            String[] strs = IP.split(":");
            if(strs.length != 8) return "Neither";
            for(String s : strs){
                if(s.length()==0 || s.equals("") || s.length()>4) return "Neither";
                for(int i=0 ; i<s.length() ; i++){
                    char c = s.charAt(i);
                    if(c>='0' && c<='9'){
                        continue;
                    } else if(c>='a' && c<='f'){
                        continue;
                    } else if(c>='A' && c<='F'){
                        continue;
                    } else {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        } else {
            System.out.println(new ArrayList<String>(Arrays.asList(IP.split("\\."))));
            if(IP.endsWith(".")) return "Neither";
            String[] strs = IP.split("\\.");
            if(strs.length!=4) return "Neither";
            for(String s : strs){
                if(s.length()==0 || s.length()>3) return "Neither";
                if(s.charAt(0)=='0' && s.length()>1) return "Neither";
                if(s.charAt(0)=='-' || s.charAt(0)=='+') return "Neither";
                int num=0;
                try {
                    num = Integer.parseInt(s);
                } catch (Exception e){
                    //e.printStackTrace();
                    return "Neither";

                }
                if(num<0 || num>255) return "Neither";;
            }
            return "IPv4";
        }
    }
}
