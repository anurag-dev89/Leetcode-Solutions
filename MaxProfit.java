public class MaxProfit {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = sol.maxm(prices);

        System.out.println("Max profit is " + result);
    }    
}

class Solution {
    public int maxm(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            
            if (prices[i] < min) {
                min = prices[i];
            } 
            else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }
}
