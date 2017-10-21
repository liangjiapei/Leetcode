// 123. Best Time to Buy and Sell Stock III
// Jiapei Liang
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
/*
  Say you have an array for which the ith element is the price of a given stock on day i.

  Design an algorithm to find the maximum profit. You may complete at most two transactions.

  Note:
  You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

// Time: O(n)
// Space: O(n)
public int maxProfit(int[] prices) {

  if (prices == null || prices.length <= 1) {
    return 0;
  }

  int[] MLeft = new int[prices.length];
  int[] MRight = new int[prices.length];

  int minPriceLeft = prices[0];
  for (int i = 1; i < prices.length; i++) {
    MLeft[i] = Math.max(MLeft[i - 1], prices[i] - minPriceLeft);
    minPriceLeft = Math.min(minPriceLeft, prices[i]);
  }

  int maxPriceRight = prices[prices.length - 1];
  for (int i = prices.length - 2; i >= 0; i--) {
    MRight[i] = Math.max(MRight[i + 1], maxPriceRight - prices[i]);
    maxPriceRight = Math.max(maxPriceRight, prices[i]);
  }

  int maxProfit = 0;
  for (int i = 0; i < prices.length; i++) {
    maxProfit = Math.max(maxProfit, MLeft[i] + MRight[i]);
  }

  return maxProfit;

}
