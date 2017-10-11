// 198. House Robber
// Jiapei Liang
// https://leetcode.com/problems/house-robber/description/
/*
  You are a professional robber planning to rob houses along a street.
  Each house has a certain amount of money stashed,
  the only constraint stopping you from robbing each of them is that
  adjacent houses have security system connected and it will automatically
  contact the police if two adjacent houses were broken into on the same night.

  Given a list of non-negative integers representing the amount of money of each house,
  determine the maximum amount of money you can rob tonight without alerting the police.
*/

// Time: O(n)
// Space: O(1)
public int rob(int[] nums) {
  if (nums == null || nums.length == 0) {
    return 0;
  }
  int n = nums.length;
  int[] M = new int[2];
  M[0] = 0;
  M[1] = nums[0];
  for (int i = 2; i <= n; i++) {
    M[i % 2] = Math.max(M[(i - 1) % 2], M[(i - 2) % 2] + nums[i - 1]);
  }
  return M[n % 2];
}
