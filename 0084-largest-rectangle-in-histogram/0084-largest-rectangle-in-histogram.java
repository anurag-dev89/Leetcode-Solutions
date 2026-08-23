class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                  (i == n || heights[stack.peek()] > heights[i])) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty())
                    width = i;
                else
                    width = i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
/*class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] right = new int[n];   // Right Smaller index
        int[] left = new int[n];    // Left Smaller index

        Stack<Integer> stack = new Stack<>();

        // Step 1 : Right Smaller
        // Traverse from LAST to FIRST
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            // If no smaller element exists
            if (stack.isEmpty())
                right[i] = n;
            else
                right[i] = stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Left Smaller
        // Traverse from FIRST to LAST
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                left[i] = -1;
            else
                left[i] = stack.peek();

            stack.push(i);
        }

        //Calculate Area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}*/