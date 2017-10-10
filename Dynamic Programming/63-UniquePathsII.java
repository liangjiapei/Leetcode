// 63. Unique Paths II
// Jiapei Liang
// https://leetcode.com/problems/unique-paths-ii/description/
/*
  Follow up for "Unique Paths":

  Now consider if some obstacles are added to the grids. How many unique paths would there be?

  An obstacle and empty space is marked as 1 and 0 respectively in the grid.

  For example,
  There is one obstacle in the middle of a 3x3 grid as illustrated below.

  [
    [0,0,0],
    [0,1,0],
    [0,0,0]
  ]
  The total number of unique paths is 2.
*/

// Time: O(mn)
// Space: O(n)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
  if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
    return 1;
  }
  if (obstacleGrid[0][0] == 1) {
      return 0;
  }
  int m = obstacleGrid.length;
  int n = obstacleGrid[0].length;
  int[] paths = new int[n];

  for (int j = 0; j < n; j++) {
    if (obstacleGrid[0][j] == 0) {
        paths[j] = 1;
    } else {
        break;
    }
  }

  for (int i = 1; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (obstacleGrid[i][j] == 0) {
        if (j != 0) {
          paths[j] = paths[j - 1] + paths[j];
        }
      } else {
        paths[j] = 0;
      }
    }
  }
  return paths[n - 1];
}
