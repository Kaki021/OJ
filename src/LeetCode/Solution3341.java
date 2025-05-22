package LeetCode;

import java.util.*;

public class Solution3341 {
    public static void main(String[] args) {
        int[][] moveTime = {{0, 4}, {4, 4}};
        System.out.println(minTimeToReach(moveTime));
    }


    public static int minTimeToReach(int[][] moveTime) {
        int length = moveTime.length;
        int width = moveTime[0].length;
        int[][] dirs = {{1, 0}, {0, 1},{-1, 0}, {0, -1}};
        int[][] dp = new int[length][width];
        boolean[][] v = new boolean[length][width];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        Queue<State> queue = new PriorityQueue<>();
        queue.offer(new State(0, 0, 0));
        while (!queue.isEmpty()) {
            State poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            if (v[x][y] == true) {
                continue;
            }
            if (x == length && y == width) {
                break;
            }
            for (int[] dir: dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= length || ny < 0 || ny >= width) {
                    continue;
                }
                int dist = Math.max(moveTime[nx][ny],  dp[x][y]) + (x + y) % 2 + 1 ;
                if (dist < dp[nx][ny]) {
                    dp[nx][ny] = dist;
                    queue.offer(new State(nx, ny, dist));
                }
            }
            v[x][y] = true;
        }
        return dp[moveTime.length -1][moveTime[0].length - 1];
    }

}
class State implements Comparable<State>{
    public int x;
    public int y;
    public int dist;

    public State(int x, int y, int dist) {
        this.x  = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(State other) {
        return this.dist - other.dist;
    }
}
