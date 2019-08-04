package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 快照数组
 *
 * @author yx
 * @create 2019-08-04  10:44
 **/
public class Q5146 {
    class SnapshotArray {
        List<TreeMap<Integer, Integer>> list = new ArrayList<>();
        int version = 0;

        public SnapshotArray(int length) {
            version = 0;
            for (int i = 0; i < length; i++) {
                TreeMap<Integer, Integer> t = new TreeMap<>();
                t.put(version, 0);
                list.add(t);
            }
        }

        public void set(int index, int val) {
            list.get(index).put(version, val);
        }

        public int snap() {
            int res = version;
            version ++;
            return res;
        }

        public int get(int index, int snap_id) {
            TreeMap<Integer, Integer> t = list.get(index);
            return t.floorEntry(snap_id).getValue();
        }
    }
}
