import java.util.*;

class solution {
    public int findMaxLength(int[] nums) {
        // Map stores: prefixSum -> first index where it appears
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // important base case

        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, keep 1 as +1
            prefixSum += (nums[i] == 0 ? -1 : 1);

            if (map.containsKey(prefixSum)) {
                // If we've seen this sum before → subarray sum = 0
                int prevIndex = map.get(prefixSum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // Store first time this sum is seen
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}

public class ContiguousArray_525 {
    public static void main(String[] args) {

        solution sol = new solution();

        System.out.println(sol.findMaxLength(new int[]{0,1}));
        System.out.println(sol.findMaxLength(new int[]{0,1,0}));
        System.out.println(sol.findMaxLength(new int[]{0,1,1,1,1,1,0,0,0}));
    }
}
