package LeetCode;

public class Solution3355 {
    class Solution {
        public boolean isZeroArray(int[] nums, int[][] queries) {
            int n = nums.length;
            int[] incrs = new int[n + 1];
            for (int i = 0; i < queries.length; i++) {
                incrs[queries[i][0]]--;
                incrs[queries[i][1] + 1]++;
            }
            int incr = 0;
            for (int i = 0; i < n; i++) {
                incr += incrs[i];
                if ((nums[i] += incr) > 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
