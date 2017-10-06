// 617. Merge Two Binary Trees
// Jiapei Liang
// https://leetcode.com/problems/merge-two-binary-trees/description/
/*
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
Note: The merging process must start from the root nodes of both trees.
*/

/**
 * Definition for binary tree
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
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
  if (t1 == null) {
    return t2;
  }

  if (t2 != null) {
    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
  }

  return t1;
}

// Method 2: Iterative DFS
// Time: O(n)
// Space: O(height)
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
  if (t1 == null) {
    return t2;
  }
  // Use stack to help DFS
  Deque<TreeNode[]> stack = new LinkedList<>();
  stack.offerLast(new TreeNode[] {t1, t2});
  while (!stack.isEmpty()) {
    TreeNode[] cur = stack.pollLast();
    // no need to merge t2 into t1
    if (cur[1] == null) {
      continue;
    }
    // merge t1 and t2
    cur[0].val += cur[1].val;
    // if node in t1 == null, use node in t2 instead
    // else put both nodes in stack to merge
    if (cur[0].left == null) {
      cur[0].left = cur[1].left;
    } else {
      stack.offerLast(new TreeNode[] {cur[0].left, cur[1].left});
    }
    if (cur[0].right == null) {
      cur[0].right = cur[1].right;
    } else {
      stack.offerLast(new TreeNode[] {cur[0].right, cur[1].right});
    }
  }
  return t1;
}


// Method 3: Iterative BFS
// Time: O(n)
// Space: O(n)
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
  if (t1 == null) {
    return t2;
  }
  // Use stack to help DFS
  Queue<TreeNode[]> queue = new LinkedList<>();
  queue.offer(new TreeNode[] {t1, t2});
  while (!queue.isEmpty()) {
    TreeNode[] cur = queue.poll();
    // no need to merge t2 into t1
    if (cur[1] == null) {
      continue;
    }
    // merge t1 and t2
    cur[0].val += cur[1].val;
    // if node in t1 == null, use node in t2 instead
    // else put both nodes in stack to merge
    if (cur[0].left == null) {
      cur[0].left = cur[1].left;
    } else {
      queue.offer(new TreeNode[] {cur[0].left, cur[1].left});
    }
    if (cur[0].right == null) {
      cur[0].right = cur[1].right;
    } else {
      queue.offer(new TreeNode[] {cur[0].right, cur[1].right});
    }
  }
  return t1;
}
