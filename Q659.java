package leetcode;

import java.util.*;
//分割数组为连续子序列
public class Q659 {

    public static void main(String[] args) {
        Q659 q = new Q659();
        int[] a = {1,2,3,3,4,4,5,5};
        System.out.println(q.isPossible2(a));
    }
    //95% 先建立一个map将数组值和其出现次数存入map
    // 将所有的子序列都存储到list<list>中，如果遍历的数组值的数量大于当前子序列数量，
    // 截取后出现的子序列，并且判断舍弃的子序列长度是否>3
    //新出现的子序列长度一定小于之前的子序列
    public boolean isPossible(int[] nums) {
        if(nums.length<3) return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<List<Integer>> lists = new ArrayList<>();
        int cur = 0;//记录当前存在的子序列在lists中的起点位置
        int pre = nums[0];
        int num0 = map.get(nums[0]);
        for(int i=0 ; i<num0 ; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            lists.add(list);
        }
        for(int i=num0 ; i<nums.length ;) {
            if(nums[i]!= pre+1){//如果数组值不连续，直接舍弃所有子序列，并判断长度
                if(lists.get(lists.size()-1).size()<3) return false;
                lists.clear();
                cur=0;
            }
            int num = map.get(nums[i]);
            if(lists.size()-cur>num){//如果存在的子序列的数量大于新出现数组值的数量
                if(lists.get(lists.size()-num-1).size()<3) return false;//舍弃的子序列中最短的子序列
                cur = lists.size()-num;//改变起点
                for(int j=cur ; j<lists.size() ; j++) {
                    lists.get(j).add(nums[i]);
                }
            } else {
                for(int j=cur ; j<lists.size() ; j++) {
                    lists.get(j).add(nums[i]);
                }
                int size = lists.size()-cur;
                while(size<num){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    lists.add(list);
                    size++;
                }
            }
            pre = nums[i];
            i = i+num;
        }
        for(List list : lists) {
            if(list.size()<3) return false;
        }
        return true;
    }
//90%  两个map，一个存储数组中元素的出现的次数，一个存储当前连续序列后面可接的数字的个数map2
//[1,2,3,3,4,5]  1,2,3后map2可以存一个4意义是123后面还可以消耗一个4，如果有就消耗，如果没有就算了，消耗后要添加一个5
    public boolean isPossible2(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        Map<Integer, Integer> appendFreqMap = new HashMap<>();
        for (int i : nums) {
            if (freqMap.get(i) == 0) {
                continue;
            } else if (appendFreqMap.getOrDefault(i, 0) > 0) {
                appendFreqMap.put(i, appendFreqMap.get(i) - 1);
                appendFreqMap.put(i + 1, appendFreqMap.getOrDefault(i + 1, 0) + 1);
            } else if (freqMap.getOrDefault(i + 1, 0) > 0 && freqMap.getOrDefault(i + 2, 0) > 0) {
                freqMap.put(i + 1, freqMap.get(i + 1) - 1);
                freqMap.put(i + 2, freqMap.get(i + 2) - 1);
                appendFreqMap.put(i + 3, appendFreqMap.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            freqMap.put(i, freqMap.get(i) - 1);
        }
        return true;
    }
}
