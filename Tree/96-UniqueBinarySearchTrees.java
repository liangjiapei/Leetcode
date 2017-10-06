// 96. Unique Binary Search Trees
// Jiapei Liang
// https://leetcode.com/problems/unique-binary-search-trees/discuss/
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

// DP Solution
// Time: O(n^2)
// Space: O(n)
public int numTrees(int n) {
  int[] M = new int[n + 1];
  M[0] = 1;
  M[1] = 1;

  // For Values 1...n
  // each value can be root
  // Therefore, the number of unique BST is F(1, n) + F(2, n) + ... + F(n, n)
  // Where F(i, n) represents the number of unique BST when i is root
  // F(i, n) = M[i - 1] * M[n - i]
  // (number of unique BST for numbers on the left of i) * (number of Unique BST for numbers on the right of i)
  // Calculate from M[0] to M[n], bottomUp approach
  for (int i = 2; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
      M[i] += M[j - 1] * M[i - j];
    }
  }
  return M[n];
}
