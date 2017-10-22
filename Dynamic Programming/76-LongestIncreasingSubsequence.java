// 76. Longest Increasing Subsequence
// Jiapei Liang
// https://leetcode.com/problems/longest-increasing-subsequence/description/
/*
  Given an unsorted array of integers, find the length of longest increasing subsequence.

  For example,
  Given [10, 9, 2, 5, 3, 7, 101, 18],
  The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

  Your algorithm should run in O(n2) complexity.

  Follow up: Could you improve it to O(n log n) time complexity?
*/

// Time: O(n^2)
// Space: O(n)
public int lengthOfLIS(int[] nums) {
  // Corner Cases
  if (nums == null || nums.length <= 0) {
    return 0;
  }

  // dp[i] represents the longest increasing subsequence from 0 to i, including i
  int[] dp = new int[nums.length];
  dp[0] = 1;
  int max = 1;

  for (int i = 1; i < nums.length; i++) {
    dp[i] = 1;
    for (int j = 0; j < i; j++) {
      if (nums[i] > nums[j]) {
        dp[i] = Math.max(dp[i], dp[j] + 1);
        max = Math.max(max, dp[i]);
      }
    }
  }

  return max;
}
