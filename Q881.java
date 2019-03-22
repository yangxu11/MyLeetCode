package leetcode;

import java.util.Arrays;
//救生艇
public class Q881 {
    //先升序排序，然后从后遍历，如果end+start<limit则上两个人，否则上一个end
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start=0;
        int end = people.length-1;
        int count=0;
        while(start<=end){
            if(end!=start){
                if(people[end]+people[start]<=limit){
                    start++;
                    end--;
                    count++;
                    continue;
                } else {
                    end--;
                    count++;
                    continue;
                }
            } else {
                count++;
                break;
            }
        }
        return count;
    }
}
