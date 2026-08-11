import java.util.*;

public class slidingwindow_239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for (int right = 0; right < n; right++) {

            // Remove smaller values from the back
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(right);

            // Remove index outside the window
            if (deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            // Window is ready
            if (right >= k - 1) {
                result[index] = nums[deque.peekFirst()];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
    }
}