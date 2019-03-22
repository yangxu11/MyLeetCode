package leetcode;

import java.util.HashSet;
import java.util.Set;

//数组嵌套
public class Q565 {
    //30ms 83%
    //建立一个数组来标记访问过的数字，如果之后遍历时数字已经访问过，直接跳过（同一个数字不可能出现在两个嵌套数组中）
    //遍历时建立一个set来存储遍历过的数字，直到出现重复，比较得到当前最大长度
    //如果已经出现了长度大于一半的，则此为最长
    public int arrayNesting(int[] nums) {
        int[] visited = new int[nums.length];
        int length = 0;

        for(int i=0 ; i<nums.length ; i++){
            if(length > nums.length/2){
                return length;
            }
            if(visited[nums[i]]==1){
                continue;
            }
            Set<Integer> set = new HashSet<>();
            int var = nums[i];
            while(set.add(var)){
                visited[var]=1;
                var = nums[var];
            }
            length = Math.max(length,set.size());
        }

        return length;
    }
}
