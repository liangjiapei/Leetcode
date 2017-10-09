// 62. Unique Paths
// Jiapei Liang
// https://leetcode.com/problems/unique-paths/description/
/*
  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
  The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
  How many possible unique paths are there?
*/

// Time: O(mn)
// Space: O(n)
public int uniquePaths(int m, int n) {
  if (m <= 0 || n <= 0) {
    return 0;
  }

  int[] paths = new int[n];
  int prev = 0;
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (i == 0 || j == 0) {
        paths[j] = 1;
      } else {
        paths[j] = prev + paths[j];
      }
      prev = paths[j];
    }
  }

  return paths[n - 1];
}
