class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always perform binary search on smaller array
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while (low <= high) {

            // Partition index in nums1
            int cut1 = (low + high) / 2;

            // Remaining elements go to left side from nums2
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            // Left side values
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            // Right side values
            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition found
            if (left1 <= right2 && left2 <= right1) {

                // Even length
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2)
                          + Math.min(right1, right2)) / 2.0;
                }

                // Odd length
                return Math.max(left1, left2);
            }

            // Move left
            else if (left1 > right2) {
                high = cut1 - 1;
            }

            // Move right
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}