package leetcode;

import java.util.ArrayList;
import java.util.List;
//格雷编码
public class Q89 {
    //执行用时: 2 ms, 在Gray Code的Java提交中击败了51.02% 的用户
    //内存消耗: 36.1 MB, 在Gray Code的Java提交中击败了0.70% 的用户

    //设00 = x  ，
    // 下一个添加x ^(异或) 01（1<<0）
    // 下一个添加 x^01^10(1<<1)=x^11 必与 x^01有一位不同,
    // 下一个添加x^10(1<<1) 必与x^01有一位不同
    //以此类推，每次将已有list的数逆序与1<<i异或，就可以得到结果
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int cur;
        for (int i = 0; i < n; i++) {
            int change = 1 << i;
            cur = res.size() - 1;
            while(cur >= 0) {
                res.add(res.get(cur) ^ change);
                cur--;
            }
        }
        return res;
    }
    //超时答案 回溯
    List<Integer> res;
    public List<Integer> grayCode1(int n) {
        int[] nums = new int[n];
        int total = (int)Math.pow(2,n);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(nums,list,total);
        return res;
    }

    public void dfs(int[] nums,List<Integer> list,int total){
        if(list.size() == total){
            res = new ArrayList<>(list);
            return;
        }
        for(int i=0 ; i<nums.length ; i++){
            nums[i] = 1 - nums[i];
            int x = getNum(nums);
            if(!list.contains(x)){
                list.add(x);
                dfs(nums,list,total);
                list.remove(list.size()-1);
            }
            nums[i] = 1-nums[i];
        }
    }
    public int getNum(int[] nums){
        int pow = 1;
        int num = 0;
        for(int i=0 ; i<nums.length ; i++){
            num+=nums[i]*pow;
            pow = 2*pow;
        }
        return num;
    }
}
