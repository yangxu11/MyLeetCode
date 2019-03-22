package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//反转字符串中的元音字母
public class Q345 {
    public String reverseVowels(String s) {
        List<Character> list= new ArrayList<Character>(Arrays.asList('a','o','e','i','u','A','O','I','E','U'));
        int start  = 0;
        int end  = s.length()-1;
        char[] str = s.toCharArray();
        while(start<end){
            while(!list.contains(str[start]) && start<end){
                start++;
            }
            while(!list.contains(str[end]) && start<end){
                end--;
            }
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }
}
