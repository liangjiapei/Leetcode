// 188. Best Time to Buy and Sell Stock IV
// Jiapei Liang
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
/*
  Say you have an array for which the ith element is the price of a given stock on day i.

  Design an algorithm to find the maximum profit. You may complete at most k transactions.

  Note:
  You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

// Time complexity: O(kn) where k is k, n is the number of prices
// Space complexity: O(kn)
public int maxProfit(int k, int[] prices) {
  int n = prices.length;
  if (k >= n/2) {
    // fast case because there are [0, n/2] continuous increases
    int maxProfit = 0;
    for (int i = 1; i < n; i++) {
      maxProfit = Math.max(maxProfit, maxProfit + prices[i] - prices[i - 1]);
    }
    return maxProfit;
  }

  // Each element dp[i][j] means the max profit of at most i transactions until day j
  int[][] dp = new int[k+1][n];

  for (int i = 1; i <= k; i++) {
    int mustSellMax = -prices[0];
    for (int j = 1; j < n; j++) {
      mustSellMax = Math.max(mustSellMax, dp[i-1][j-1] - prices[j-1]);
      dp[i][j] = Math.max(dp[i][j-1], mustSellMax + prices[j]);
    }

  }
  return dp[k][n-1];
}
