package leetcode;
//加油站  如果gas总量小于cost总量 return-1
//end从头开始 start从末尾开始，如果总和sum大于0  end就可以进一步，否则start退一步知道sum大于0
public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            } else {
                start--;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? start : -1;
    }
}
