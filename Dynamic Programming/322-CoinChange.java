// 322. Coin Change
// Jiapei Liang
// https://leetcode.com/problems/coin-change/description/
/*
  You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

  Example 1:
  coins = [1, 2, 5], amount = 11
  return 3 (11 = 5 + 5 + 1)

  Example 2:
  coins = [2], amount = 3
  return -1.

  Note:
  You may assume that you have an infinite number of each kind of coin.
*/

// Time: O(mn)
// Space: O(n)
public int coinChange(int[] coins, int amount) {
  if (coins == null || coins.length == 0 || amount < 0) {
    return -1;
  }

  int[] M = new int[amount + 1];
  // Assumption: if amount = 0, has 0 way
  M[0] = 0;

  for (int i = 1; i <= amount; i++) {
    M[i] = -1;
    for (int j = 0; j < coins.length; j++) {
      if (i >= coins[j] && M[i - coins[j]] != -1) {
        if (M[i] == -1 || M[i - coins[j]] + 1 < M[i]) {
          M[i] = M[i - coins[j]] + 1;
        }
      }
    }
  }

  return M[amount];
}
