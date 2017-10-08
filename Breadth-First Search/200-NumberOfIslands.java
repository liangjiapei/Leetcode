// 200. Number Of Islands
// Jiapei Liang
// https://leetcode.com/problems/number-of-islands/description/
/*
  Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

  Example 1:

  11110
  11010
  11000
  00000
  Answer: 1

  Example 2:

  11000
  11000
  00100
  00011
  Answer: 3
*/

// Method 1: BFS
// Time: O(mn)
// Space: O(mn) if cannot change grid
//        O(1) if can change grid
public int numIslands(char[][] grid) {
  if (grid == null || grid.length == 0 || grid[0].length == 0) {
    return 0;
  }

  int m = grid.length;
  int n = grid[0].length;

  // avoid duplicate visit
  // if can change grid, can make grid[i][j] to '0' instead of using visited
  boolean[][] visited = new boolean[m][n];
  int count = 0;

  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (grid[i][j] == '1' && !visited[i][j]) {
        bfs(grid, i, j, visited);
        count++;
      }
    }
  }

  return count;
}

// Helper Class: Cell
static class Cell {
  int row;
  int col;
  Cell(int row, int col) {
    this.row = row;
    this.col = col;
  }
}

// Helper Function: bfs
private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
  int[] dx = new int[] {-1, 0, 1, 0};
  int[] dy = new int[] {0, 1, 0, -1};
  // Use queue to help bfs
  Queue<Cell> queue = new LinkedList<>();
  queue.offer(new Cell(i, j));
  visited[i][j] = true;
  while (!queue.isEmpty()) {
    Cell cur = queue.poll();
    int row = cur.row;
    int col = cur.col;

    // check the top, right, bottom, left cells of current cell
    for (int k = 0; k < 4; k++) {
      int nextRow = row + dx[k];
      int nextCol = col + dy[k];
      if (validatePosition(nextRow, nextCol, grid)) {
        if (grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]) {
          queue.offer(new Cell(nextRow, nextCol));
          visited[nextRow][nextCol] = true;
        }
      }
    }

  }
}

// Helper Function: validatePosition
private boolean validatePosition(int row, int col, char[][] grid) {
  return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
}

// Method 2: DFS
// Time: O(mn)
// Space: O(mn) if cannot change grid
//        O(1) if can change grid
public int numIslands(char[][] grid) {
  if (grid == null || grid.length == 0 || grid[0].length == 0) {
    return 0;
  }

  int m = grid.length;
  int n = grid[0].length;

  // avoid duplicate visit
  // if can change grid, can make grid[i][j] to '0' instead of using visited
  boolean[][] visited = new boolean[m][n];
  int count = 0;

  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (grid[i][j] == '1' && !visited[i][j]) {
        dfs(grid, i, j, visited);
        count++;
      }
    }
  }

  return count;
}

// Helper Function: dfs
public void dfs(char[][] grid, int row, int col, boolean[][] visited) {
  if (validatePosition(row, col, grid) && grid[row][col] == '1' && !visited[row][col]) {
    visited[row][col] = true;
    dfs(grid, row - 1, col, visited);
    dfs(grid, row, col + 1, visited);
    dfs(grid, row + 1, col, visited);
    dfs(grid, row, col - 1, visited);
  }
}

// Helper Function: validatePosition
private boolean validatePosition(int row, int col, char[][] grid) {
  return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
}
