// 104. Maximum Depth of Binary Tree
// Jiapei Liang
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
// Given a binary tree, find its maximum depth.
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Method 1: Recursion Solution
// Time: O(n)
// Space: O(n)
public int maxDepth(TreeNode root) {
  // base case
  if (root == null) {
    return 0;
  }
  // Find the maxDepth of left sub tree
  int left = maxDepth(root.left);
  // Find the maxDepth of right sub tree
  int right = maxDepth(root.right);
  // return the max depth of left / right subtree + 1(root)
  return 1 + Math.max(left, right);
}

// Method 2: Iterative BFS
// Time: O(n)
// Space: O(n)
public int maxDepth(TreeNode root) {
  // Corner case
  if (root == null) {
    return 0;
  }
  // Use queue to help level order traversal
  Queue<TreeNode> queue = new LinkedList<>();
  queue.offer(root);
  // count the number of levels of tree
  int count = 0;
  while (!queue.isEmpty()) {
    for (int size = queue.size(); size > 0; size--) {
      TreeNode cur = queue.poll();
      if (cur.left != null) {
        queue.offer(cur.left);
      }
      if (cur.right != null) {
        queue.offer(cur.right);
      }
    }
    // Finished current level, count++
    count++;
  }
  return count;
}

// Method 3: Iterative DFS
// Time: O(n)
// Space: O(n)
public int maxDepth(TreeNode root) {
  // Corner case
  if (root == null) {
    return 0;
  }
  // Use a stack to help iterative dfs
  Deque<TreeNode> stack = new LinkedList<>();
  // Use another stack to count levels
  Deque<Integer> level = new LinkedList<>();
  stack.offerLast(root);
  level.offerLast(1);
  int max = 0;
  while (!stack.isEmpty()) {
    TreeNode curNode = stack.pollLast();
    int curLevel = level.pollLast();
    // Update max depth if possible
    max = Math.max(max, curLevel);
    if (curNode.left != null) {
      stack.offerLast(curNode.left);
      level.offerLast(curLevel + 1);
    }
    if (curNode.right != null) {
      stack.offerLast(curNode.right);
      level.offerLast(curLevel + 1);
    }
  }
  return max;
}
