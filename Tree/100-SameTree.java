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
  Deque<TreeNode> stackP = new LinkedList<>();
  Deque<TreeNode> stackQ = new LinkedList<>();
  stackP.offerLast(p);
  stackQ.offerLast(q);
  while (!stackP.isEmpty() && !stackQ.isEmpty()) {
    TreeNode curP = stackP.pollLast();
    TreeNode curQ = stackQ.pollLast();
    // Validate
    if (curP == null && curQ == null) {
      continue;
    } else if (curP == null || curQ == null) {
      return false;
    } else if (curP.val != curQ.val) {
      return false;
    }
    // Offer children nodes
    stackP.offerLast(curP.left);
    stackP.offerLast(curP.right);

    stackQ.offerLast(curQ.left);
    stackQ.offerLast(curQ.right);
  }
  return true;
}


// Method 3: Iterative BFS
// Time: O(n)
// Space: O(height)
public boolean isSameTree(TreeNode p, TreeNode q) {
  // Use Deque to help DFS
  Queue<TreeNode> queueP = new LinkedList<>();
  Queue<TreeNode> queueQ = new LinkedList<>();
  queueP.offer(p);
  queueQ.offer(q);
  while (!queueP.isEmpty() && !queueQ.isEmpty()) {
    TreeNode curP = queueP.poll();
    TreeNode curQ = queueQ.poll();
    // Validate
    if (curP == null && curQ == null) {
      continue;
    } else if (curP == null || curQ == null) {
      return false;
    } else if (curP.val != curQ.val) {
      return false;
    }
    // Offer children nodes
    queueP.offer(curP.left);
    queueP.offer(curP.right);

    queueQ.offer(curQ.left);
    queueQ.offer(curQ.right);
  }
  return true;
}
