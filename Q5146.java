package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 快照数组
 *
 * @author yx
 * @create 2019-08-04  10:44
 **/
public class Q5146 {
    class SnapshotArray {
        int[] cur;

        Map<Integer,int[]> map = new HashMap<>();

        boolean flag = false;

        int snap_id=0;

        public SnapshotArray(int length) {
            cur = new int[length];
        }

        public void set(int index, int val) {
            cur[index] = val;
            flag = true;
        }

        public int snap() {
            snap_id ++;
            if(flag){
                map.put(snap_id, Arrays.copyOf(cur,cur.length));
            } else{
                map.put(snap_id,cur);
            }
            flag = false;
            return snap_id-1;
        }

        public int get(int index, int snap_id) {
            int[] nums = map.get(snap_id);
            return nums[index];
        }
    }
}
