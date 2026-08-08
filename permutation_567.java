public class permutation_567 {

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count characters of s1
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        // First window of s2
        for (int i = 0; i < s1.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(freq1, freq2)) {
            return true;
        }

        // Sliding window
        for (int right = s1.length(); right < s2.length(); right++) {

            // Add new character
            freq2[s2.charAt(right) - 'a']++;

            // Remove old character
            int left = right - s1.length();
            freq2[s2.charAt(left) - 'a']--;

            if (matches(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
     public static boolean matches(int[] freq1, int[] freq2) {

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
        }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = checkInclusion(s1, s2);

        System.out.println(result);
    }
}