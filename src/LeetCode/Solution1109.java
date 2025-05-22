package LeetCode;


/**
 * https://leetcode.cn/problems/corporate-flight-bookings/description/
 */
public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] deltaArray = new int[n + 1];
        int[] nums = new int[n];
        for (int[]booking : bookings) {
            deltaArray[booking[0] - 1] += booking[2];
            deltaArray[booking[1]] -= booking[2];
        }
        int delta = 0;
        for (int i = 0; i < n; i++) {
            delta += deltaArray[i];
            nums[i] += delta;
        }
        return nums;
    }
}
