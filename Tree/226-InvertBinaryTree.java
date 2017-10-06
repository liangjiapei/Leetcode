// 226. Invert Binary Tree
// Jiapei Liang
// https://leetcode.com/problems/invert-binary-tree/description/
/*
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to

     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/

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
public TreeNode invertTree(TreeNode root) {
  // Base case
  if (root == null) {
    return null;
  }
  // Store references for root.left and root.right
  final TreeNode left = root.left;
  final TreeNode right = root.right;
  // invert right subtree, and make it the left subtree of root
  root.left = invertTree(right);
  // invert left subtree, and make it the right subtree of root
  root.right = invertTree(left);
  return root;
}

// Method 2: Iterative DFS
// Time: O(n)
// Space: O(height)
public TreeNode invertTree(TreeNode root) {
  // Corner case
  if (root == null) {
    return null;
  }

  // Use a stack to help DFS
  Deque<TreeNode> stack = new LinkedList<>();
  stack.offerLast(root);

  while (!stack.isEmpty()) {
    TreeNode cur = stack.pollLast();
    // invert left and right subtrees of cur
    TreeNode left = cur.left;
    cur.left = cur.right;
    cur.right = left;
    // offer left and right nodes to stack so that they can invert their subtrees
    if (cur.left != null) {
      stack.offerLast(cur.left);
    }
    if (cur.right != null) {
      stack.offerLast(cur.right);
    }
  }

  return root;
}

// Method 3: Iterative BFS
// Time: O(n)
// Space: O(n)
public TreeNode invertTree(TreeNode root) {
  // Corner case
  if (root == null) {
    return null;
  }

  // Use a stack to help DFS
  Queue<TreeNode> queue = new LinkedList<>();
  queue.offer(root);

  while (!queue.isEmpty()) {
    TreeNode cur = queue.poll();
    // invert left and right subtrees of cur
    TreeNode left = cur.left;
    cur.left = cur.right;
    cur.right = left;
    // offer left and right nodes to stack so that they can invert their subtrees
    if (cur.left != null) {
      queue.offer(cur.left);
    }
    if (cur.right != null) {
      queue.offer(cur.right);
    }
  }

  return root;
}
