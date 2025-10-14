import java.util.HashSet;

class LongestConsSeq {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        HashSet<Integer> set= new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }
        int longest =0;

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currNum = n;
                int cnt = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    cnt++;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }
    public static void main(String[] args) {
        LongestConsSeq lcs = new LongestConsSeq();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums));
    }
 
}