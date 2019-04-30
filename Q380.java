package leetcode;

import java.util.*;

// 常数时间插入、删除和获取随机元素
public class Q380 {

}
class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> map;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;

        map.put(val,nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // replace the last one
        // remove the last one
        if(!map.containsKey(val))
            return false;
        int idx = map.get(val);
        if(idx != nums.size()-1)
        {
            int last = nums.get(nums.size()-1);
            nums.set(idx,last);
            map.put(last,idx);
        }
        nums.remove(nums.size()-1);
        map.remove(val);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(r.nextInt(nums.size()));
    }
}
