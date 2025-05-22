package LeetCode;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
public class Solution2900 {
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        int curValue = groups[0];
        List<String> sequences = new ArrayList<>();
        sequences.add(words[0]);
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != curValue) {
                curValue = groups[i];
                sequences.add(words[i]);
            }
        }
        return sequences;
    }
}
