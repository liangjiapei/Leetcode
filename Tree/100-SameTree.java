// 100. Same Tree
// Jiapei Liang
// https://leetcode.com/problems/same-tree/description/
// Given two binary trees, write a function to check if they are equal or not.
// Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Method 1: Recursive Solution
// Time: O(n)
// Space: O(height)
public boolean isSameTree(TreeNode p, TreeNode q) {
  // base cases
  if (p == null && q == null) {
    return true;
  } else if (p == null || q == null) {
    return false;
  } else if (p.val != q.val) {
    return false;
  }
  return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}

// Method 2: Iterative DFS
// Time: O(n)
// Space: O(height)
public boolean isSameTree(TreeNode p, TreeNode q) {
  // Use Deque to help DFS
  Deque<TreeNode[]> stack = new LinkedList<>();
  stack.offerLast(new TreeNode[] {p, q});
  while (!stack.isEmpty()) {
    TreeNode[] cur = stack.pollLast();
    // Validate
    if (cur[0] == null && cur[1] == null) {
      continue;
    } else if (cur[0] == null || cur[1] == null) {
      return false;
    } else if (cur[0].val != cur[1].val) {
      return false;
    }
    // Offer children nodes
    stack.offerLast(new TreeNode[] {cur[0].left, cur[1].left});
    stack.offerLast(new TreeNode[] {cur[0].right, cur[1].right});
  }
  return true;
}


// Method 3: Iterative BFS
// Time: O(n)
// Space: O(height)
public boolean isSameTree(TreeNode p, TreeNode q) {
  // Use Deque to help DFS
  Queue<TreeNode[]> queue = new LinkedList<>();
  queue.offer(new TreeNode[] {p, q});
  while (!queue.isEmpty()) {
    TreeNode[] cur = queue.poll();
    // Validate
    if (cur[0] == null && cur[1] == null) {
      continue;
    } else if (cur[0] == null || cur[1] == null) {
      return false;
    } else if (cur[0].val != cur[1].val) {
      return false;
    }
    // Offer children nodes
    queue.offer(new TreeNode[] {cur[0].left, cur[1].left});
    queue.offer(new TreeNode[] {cur[0].right, cur[1].right});
  }
  return true;
}
