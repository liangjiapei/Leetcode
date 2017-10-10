// 55. Jump Game
// Jiapei Liang
// https://leetcode.com/problems/jump-game/description/
/*
  Given an array of non-negative integers, you are initially positioned at the first index of the array.

  Each element in the array represents your maximum jump length at that position.

  Determine if you are able to reach the last index.

  For example:
  A = [2,3,1,1,4], return true.

  A = [3,2,1,0,4], return false.
*/

// Method 1: Dynamic Programming
// Time: O(n^2)
// Space: O(n)
public boolean canJump(int[] nums) {
  if (nums == null || nums.length <= 1) {
    return true;
  }
  boolean[] canJump = new boolean[nums.length];
  canJump[0] = true;

  for (int i = 1; i < canJump.length; i++) {
    for (int j = 0; j < i; j++) {
      if (canJump[j] && j + nums[j] >= i) {
        canJump[i] = true;
        break;
      }
    }
  }

  return canJump[nums.length - 1];
}

// Method 2: Greedy
// Time: O(n)
// Space: O(1)
public boolean canJump(int[] nums) {
  if (nums == null || nums.length <= 1) {
    return true;
  }
  int canReach = nums[0];
  for (int i = 0; i <= canReach && i < nums.length; i++) {
    canReach = Math.max(canReach, i + nums[i]);
  }
  return canReach >= nums.length - 1;
}
