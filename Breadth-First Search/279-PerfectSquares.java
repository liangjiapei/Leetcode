// 279. Perfect Squares
// Jiapei Liang
// https://leetcode.com/problems/perfect-squares/description/
/*
  Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
  For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/

// Method 1: BFS
// Time:
// Space:
public int numSquares(int n) {

}

// Method 2: DP
// Time: O(n*sqrt(n)) = O(n^1.5)
// Space: O(n)
public int numSquares(int n) {
  if (n < 4) {
    return n;
  }
  int[] M = new int[n + 1];
  M[1] = 1;
  M[2] = 2;
  M[3] = 3;

  for (int i = 4; i <= n; i++) {
    M[i] = i;
    for (int j = 1; j * j <= i; j++) {
      M[i] = Math.min(M[i], M[i - j * j] + 1);
    }
  }

  return M[n];
}
