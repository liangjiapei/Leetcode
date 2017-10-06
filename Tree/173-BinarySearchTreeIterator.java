// 173. Binary Search Tree Iterator
// Jiapei Liang
// https://leetcode.com/problems/binary-search-tree-iterator/description/
/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
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

public class BSTIterator {

  private Deque<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new LinkedList<>();
    pushAll(root);
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = stack.pollLast();
    pushAll(node.right);
    return node.val;
  }

  private void pushAll(TreeNode root) {
    while (root != null) {
      stack.offerLast(root);
      root = root.left;
    }
  }
}
