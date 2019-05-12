package leetcode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 *
 * @author yx
 * @create 2019-05-12  10:31
 **/
public class Q32 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==0) return "";
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : numbers){
            list.add(num);
        }

        Comparator<Integer> comp = new Comparator<Integer>(){
            @Override
            public int compare(Integer str1,Integer str2){
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        };
        Collections.sort(list,comp);
        StringBuilder res = new StringBuilder();
        for(int num : list){
            res.append(String.valueOf(num));
        }
        return res.toString();

    }
}
