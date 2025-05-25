package LeetCode;

import org.w3c.dom.xpath.XPathResult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2131 {

    public static void main(String[] args) {
        Solution2131 solution2131 = new Solution2131();
        String[] words = {"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"};
        int i = solution2131.longestPalindrome(words);
        return;
    }

    public int longestPalindrome(String[] words) {
        int res = 0;
        Map<String, Integer> wordCoutMap = new HashMap<>();
        Set<String> hasUserWord = new HashSet<>();
        for (String word : words) {
            wordCoutMap.put(word, wordCoutMap.getOrDefault(word, 0) + 1);
        }
        boolean isNeedAdd = false;
        for (String word : wordCoutMap.keySet()) {
            if (hasUserWord.contains(word)) {
                continue;
            }
            String palindrome = getPalindrome(word);
            if (isPalindrome(word)) {
                res += wordCoutMap.get(word) / 2 * 2 * 2;
                isNeedAdd = isNeedAdd || wordCoutMap.get(word) % 2 == 1;
            } else {
                res += Math.min(wordCoutMap.getOrDefault(palindrome, 0),
                        wordCoutMap.getOrDefault(word, 0)) * 4;
            }
            hasUserWord.add(palindrome);
            hasUserWord.add(word);
        }
        return res + (isNeedAdd ? 2 : 0);
    }

    public String getPalindrome(String word) {
        return Character.toString(word.charAt(1)) + word.charAt(0);
    }

    public boolean isPalindrome(String word) {
        return word.charAt(0) == word.charAt(word.length() - 1);
    }
}
