package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Soluation3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] delteArray = new int[n + 1];
        int incr = 0;
        for (int i = 0, j = 0; i < n; i++) {
            incr += delteArray[i];
            while (j < queries.length &&  queries[j][0] == i) {;
                pq.offer(queries[j][1] + 1);
                j++;
            }
            while (incr < nums[i] && !pq.isEmpty() && pq.peek() > i) {
                incr ++;
                delteArray[pq.poll()] --;
            }
            if (incr < nums[i]) {
                return -1;
            }
        }
        return pq.size();
    }
}
