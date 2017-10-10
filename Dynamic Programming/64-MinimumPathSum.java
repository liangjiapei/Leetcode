// 64. Minimum Path Sum
// Jiapei Liang
// https://leetcode.com/problems/minimum-path-sum/description/
/*
  Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

  Note: You can only move either down or right at any point in time.
*/

// Time: O(mn)
// Space: O(n)
public int minPathSum(int[][] grid) {
  if (grid == null || grid.length == 0 || grid[0].length == 0) {
    return 0;
  }
  int m = grid.length;
  int n = grid[0].length;
  int[] min = new int[n];
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (i == 0) {
        min[j] = j == 0 ? grid[i][j] : min[j - 1] + grid[i][j];
      } else if (j == 0) {
        min[j] = min[j] + grid[i][j];
      } else {
        min[j] = Math.min(min[j - 1], min[j]) + grid[i][j];
      }
    }
  }
  return min[n - 1];
}
