class TwoSum_167 {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = {5, 25, 75};
        int target = 100;

        int[] result = twoSum(numbers, target);

        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}