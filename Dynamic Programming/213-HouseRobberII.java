// 213. House Robber II
// Jiapei Liang
// https://leetcode.com/problems/house-robber-ii/description/
/*
  After robbing those houses on that street,
  the thief has found himself a new place for his thievery so that he will not
  get too much attention. This time, all houses at this place are arranged in a circle.
  That means the first house is the neighbor of the last one.
  Meanwhile, the security system for these houses remain the same as
  for those in the previous street.

  Given a list of non-negative integers representing the amount of money of each house,
  determine the maximum amount of money you can rob tonight without alerting the police.
*/

// Time: O(n)
// Space: O(1)
public int rob(int[] nums) {
  if (nums == null || nums.length == 0) {
    return 0;
  }
  if (nums.length == 1) {
    return nums[0];
  }
  return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
}

// Helper Method: rob
public int rob(int[] nums, int start, int end) {
  int n = end - start + 1;
  int[] M = new int[2];
  M[0] = 0;
  M[1] = nums[start];
  for (int i = 2; i <= n; i++) {
    M[i % 2] = Math.max(M[(i - 1) % 2], M[(i - 2) % 2] + nums[start + i - 1]);
  }
  return M[n % 2];
}
