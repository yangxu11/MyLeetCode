package leetcode;

import java.util.HashMap;
import java.util.Map;
//森林中的兔子
public class Q781 {

    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<answers.length ; i++) {
            if(map.containsKey(answers[i])) {
                map.put(answers[i],map.get(answers[i])+1);
            } else {
                map.put(answers[i],1);
            }
        }
        int min = 0;
        for(int a : map.keySet()) {
            int number = map.get(a);
            if(number%(a+1)==0) {
                number = number/(a+1);
            } else {
                number = number/(a+1) + 1;
            }
            min = min + (a+1)*number;
        }
        return min;
    }

}
