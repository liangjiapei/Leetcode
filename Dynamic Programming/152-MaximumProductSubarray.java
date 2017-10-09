// 152. Maximum Product Subarray
// Jiapei Liang
// https://leetcode.com/problems/maximum-product-subarray/description/
/*
  Find the contiguous subarray within an array (containing at least one number) which has the largest product.

  For example, given the array [2,3,-2,4],
  the contiguous subarray [2,3] has the largest product = 6.
*/

// Time: O(n)
// Space: O(1)
public int maxProduct(int[] nums) {
  if (nums == null || nums.length == 0) {
    return 0;
  }

  int prevMax = nums[0];
  int prevMin = nums[0];
  int curMax = nums[0];
  int curMin = nums[0];
  int result = nums[0];

  for (int i = 1; i < nums.length; i++) {
    if (nums[i] > 0) {
      curMax = Math.max(nums[i], prevMax * nums[i]);
      curMin = Math.min(nums[i], prevMin * nums[i]);
    } else {
      curMax = Math.max(nums[i], prevMin * nums[i]);
      curMin = Math.max(nums[i], prevMax * nums[i]);
    }
    result = Math.max(result, curMax);
    prevMax = curMax;
    prevMin = curMin;
  }

  return result;
}
