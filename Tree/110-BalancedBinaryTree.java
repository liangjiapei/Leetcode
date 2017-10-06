// 110. Balanced Binary Tree
// Jiapei Liang
// https://leetcode.com/problems/balanced-binary-tree/description/
/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
public boolean isBalanced(TreeNode root) {
  if (root == null) {
    return true;
  }
  return getHeight(root) != -1;
}

// Helper function: get the height of the tree with the root node
// return height if tree is balanced
// else return -1
private int getHeight(TreeNode root) {
  if (root == null) {
    return 0;
  }
  int left = getHeight(root.left);

  if (left == -1) {
    return -1;
  }

  int right = getHeight(root.right);

  if (right == -1) {
    return -1;
  }

  if (Math.abs(left - right) > 1) {
    return -1;
  }

  return 1 + Math.max(left, right);
}

// Method 2: Iterative Solution (Post-order Traversal)
// Time: O(n)
// Space: O(height)
boolean isBalanced(TreeNode root) {
  if(root == null) {
    return true;
  }

  Deque<Integer> heights = new LinkedList<>();
  Deque<TreeNode> stack = new LinkedList<>();
  stack.offerLast(root);

  //set to root not null to not confuse when root is misisng children
  TreeNode prev = root;

  while(!stack.isEmpty()) {
    //get the next node to process, peek because we need to maintain trail until we return
    TreeNode curr = stack.peekLast();

    //if we just returned from left child
    if (prev == curr.left) {
      if (curr.right != null) {
        //if we can go right go
        stack.offerLast(curr.right);
      } else {
        //otherwise right height is -1 does not exist and combine heights
        heights.offerLast(0);
        if (!combineHeights(heights)) {
          return false;
        }
        stack.pollLast(); //back to parent
      }
    } else if (curr.right == prev) { //if we just returned from right child
      if (!combineHeights(heights)) {
        return false;
      }
      stack.pollLast(); //up to parent
    } else {
      //this came from a parent, first thing is to visit the left child, or right if no left
      if (curr.left != null) {
        stack.offerLast(curr.left);
      } else {
        if (curr.right != null) {
          //no left so when we combine this node left is 0
          heights.offerLast(0);
          //since we never go left above logic does not go right, so we must here
          stack.offerLast(curr.right);
        } else {
          //no children set height to 1
          heights.offerLast(1);
          stack.pollLast(); //back to parent
        }
      }
    }

    prev = curr;
  }

  return true;
}

// Helper function: combineHeights
// pop both previous heights and make sure they are balanced,
// if not return false, if so return true and push the greater + 1
private boolean combineHeights(Deque<Integer> heights) {
  int rightHeight = heights.pollLast();
  int leftHeight = heights.pollLast();

  if(Math.abs(leftHeight - rightHeight) > 1) {
    return false;
  } else {
    heights.offerLast(Math.max(leftHeight, rightHeight) + 1);
    return true;
  }
}
