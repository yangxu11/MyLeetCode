package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

// 常数时间插入、删除和获取随机元素
public class Q380 {

}
class RandomizedSet {
    LinkedList<Integer>[] table;
    HashSet set ;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet();
        table = new LinkedList[13];
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return 0;
    }
}
