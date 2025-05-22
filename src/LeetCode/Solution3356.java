package LeetCode;

import com.sun.org.apache.xerces.internal.xni.XMLResourceIdentifier;

import java.util.Arrays;

public class Solution3356 {

    public static void main(String[] args) {
        Solution3356 solution3356 = new Solution3356();
        int[] nums = {2, 0, 2};
        int[][] queries = {{0,2,1}, {0,2,1}, {1,1,3}};
        int i = solution3356.minZeroArray(nums, queries);
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0;
        int right = queries.length;
        int mid = -1;
        boolean midExist = false;
        int sum = 0;
        for (int i = 0; i < right; i++) {
            sum += nums[i];
        }
        if (sum == 0) {
            return 0;
        }
        while(left < right) {
            mid = left + (right - left  >> 1);
            boolean result = isZeroArray(Arrays.copyOf(nums, nums.length), Arrays.copyOfRange(queries, 0, mid + 1));
            if (result) {
                right = mid;
                midExist = true;
            } else {
                left = mid + 1;
            }
        }
        return midExist ? right + 1 : -1;
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] incrs = new int[n + 1];
        for (int i = 0; i < queries.length; i++) {
            incrs[queries[i][0]] -= queries[i][2];
            incrs[queries[i][1] + 1] += queries[i][2];
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
