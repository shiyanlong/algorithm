package study.string;

import java.util.HashSet;
import java.util.Set;

public class Day24 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int sum = 0, start = 0, end = 0;
        Set<Character> set = new HashSet<>();

        while (start < len && end < len) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end ++));
                sum = Integer.max(sum, end - start);
            } else set.remove(s.charAt(start ++));
        }
        return sum;
    }
}
