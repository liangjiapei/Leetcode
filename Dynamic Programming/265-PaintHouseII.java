// 265. Paint House II
// Jiapei Liang
// https://leetcode.com/problems/paint-house-ii/description/
/*
  There are a row of n houses, each house can be painted with one of the k colors.
  The cost of painting each house with a certain color is different.
  You have to paint all the houses such that no two adjacent houses have the same color.

  The cost of painting each house with a certain color is represented by a n x k cost matrix.
  For example, costs[0][0] is the cost of painting house 0 with color 0;
  costs[1][2] is the cost of painting house 1 with color 2,
  and so on... Find the minimum cost to paint all houses.
*/

// Time: O(nk)
// Space: O(1)
public int minCostII(int[][] costs) {
  if (costs == null || costs.length == 0 || costs[0].length == 0) {
    return 0;
  }
  int m = costs.length, n = costs[0].length;
  if (n == 1) {
    return m == 1 ? costs[0][0] : -1;
  }
  int prevMin = 0, prevMinIndex = -1, prevSecMin = 0;
  for (int i = 0; i < m; i++) {
    int min = Integer.MAX_VALUE, minIndex = -1, secMin = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      int cost = costs[i][j] + (j == prevMinIndex ? prevSecMin : prevMin);
      if (minIndex < 0) {
        min = cost;
        minIndex = j;
      } else if (cost < min) {
        secMin = min;
        min = cost;
        minIndex = j;
      } else if (cost < secMin) {
        secMin = cost;
      }
    }
    prevMin = min;
    prevMinIndex = minIndex;
    prevSecMin = secMin;
  }
  return prevMin;
}
