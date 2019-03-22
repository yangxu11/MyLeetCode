package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//子域名访问计数
public class Q811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0 ; i<cpdomains.length ; i++) {
            String str1 = cpdomains[i];
            String[] strs = str1.split(" ");
            int count = Integer.parseInt(strs[0]);
            String str = strs[1];
            while(str.indexOf(".")!=-1) {
                if(map.containsKey(str)) {
                    map.put(str,map.get(str)+count);
                } else {
                    map.put(str,count);
                }
                int index= str.indexOf(".");
                str = str.substring(index+1);
            }
            if(map.containsKey(str)) {
                map.put(str,map.get(str)+count);
            } else {
                map.put(str,count);
            }
        }

        for(String key : map.keySet()) {
            list.add(map.get(key)+" "+key);
        }
        return list;

    }

}
