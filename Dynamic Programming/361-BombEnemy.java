// 361. Bomb Enemy
// Jiapei Liang
// https://leetcode.com/problems/bomb-enemy/description/
/*
  Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
  The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
  Note that you can only put the bomb at an empty cell.

  Example:
  For the given grid

  0 E 0 0
  E 0 W E
  0 E 0 0

  return 3. (Placing a bomb at (1,1) kills 3 enemies)
*/

// Time: O(mn)
// Space: O(n)
public int maxKilledEnemies(char[][] grid) {
  if (grid == null || grid.length == 0 || grid[0].length == 0) {
    return 0;
  }
  int m = grid.length;
  int n = grid[0].length;
  int result = 0;
  int enemiesInRow = 0;
  int[] enemiesInCols = new int[n];
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      // count enemies in current row
      if (j == 0 || grid[i][j - 1] == 'W') {
        for (int k = j; k < n && grid[i][k] != 'W'; k++) {
          if (grid[i][k] == 'E') {
            enemiesInRow++;
          }
        }
      }
      // count enemies in current col
      if (i == 0 || grid[i - 1][j] == 'W') {
        // reset enemiesInCols[j] to 0
        enemiesInCols[j] = 0;
        for (int k = i; k < m && grid[k][j] != 'W'; k++) {
          if (grid[k][j] == 'E') {
            enemiesInCols[j]++;
          }
        }
      }
      // Update result if needed
      if (grid[i][j] == '0') {
        result = Math.max(result, rows + enemiesInCols[j]);
      }
    }
  }
  return result;
}
