import java.util.HashSet;
import java.util.Set;

public class LongSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int j = 0, maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (set.contains(c)) {
                set.remove(s.charAt(j));
                j++;
            }

            set.add(c);
            maxLen = Math.max(maxLen, i - j + 1);
        }

        return maxLen;
    }
    public static void main(String[] args) {
        LongSubstring_3 lss = new LongSubstring_3();
        String s = "abcabcbb";
        System.out.println(lss.lengthOfLongestSubstring(s));
    }
}

