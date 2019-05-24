package leetcode;

/**
 * 环形数组循环
 *
 * @author yx
 * @create 2019-05-24  17:58
 **/
public class Q457 {
    //记录遍历过的节点，因为如果上次失败的话这次会走同样的路径，直接跳过
    //每次循环，记录该次循环走过的节点，如果重复，说明有循环
    //记录上个节点的坐标，如果这次和上次相同，说明循环长度为1，跳出
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if(n<=1) return false;
        boolean[] visited = new boolean[n];

        for(int i=0 ; i<n ; i++){
            if(!visited[i]){
                boolean[] tmp = new boolean[n];
                boolean flag = true;
                int sign = nums[i]>0 ? 1 : -1;
                int index = i;
                int preindex = i;
                while(!tmp[index]){
                    tmp[index] = true;
                    preindex = index;
                    visited[index] = true;
                    int num = nums[index];
                    int sub = index + num;
                    if(sub<0){
                        index = n + sub%n;
                    } else if(sub>=n){
                        index = sub%n;
                    } else {
                        index = sub;
                    }
                    if(nums[index]*sign < 0 || preindex == index){
                        flag = false;
                        break;
                    }

                }
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
}
