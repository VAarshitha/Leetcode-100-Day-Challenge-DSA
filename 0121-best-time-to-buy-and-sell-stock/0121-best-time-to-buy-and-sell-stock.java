import java.util.*;

public class Solution {
    // Method to calculate the maximum profit
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Example input
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Create an instance of Solution and call the method
        Solution solution = new Solution();
        int result = solution.maxProfit(prices);

        // Print the result
        System.out.println("Maximum Profit: " + result);
    }
}
