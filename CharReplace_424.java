public class CharReplace_424 {

    public static int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {

            // Update frequency of current character
            freq[s.charAt(right) - 'A']++;

            // Update maximum frequency in the current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // Shrink window if it becomes invalid
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update maximum window length
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        int ans = characterReplacement(s, k);

        System.out.println("Longest Repeating Character Replacement = " + ans);
    }
}