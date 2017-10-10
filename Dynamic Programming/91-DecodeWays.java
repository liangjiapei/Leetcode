// 91. Decode Ways
// Jiapei Liang
// https://leetcode.com/problems/decode-ways/description/
/*
  A message containing letters from A-Z is being encoded to numbers using the following mapping:

  'A' -> 1
  'B' -> 2
  ...
  'Z' -> 26
  Given an encoded message containing digits, determine the total number of ways to decode it.

  For example,
  Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

  The number of ways decoding "12" is 2.
*/

// Method 1
// Time: O(n)
// Space: O(n)
public int numDecodings(String s) {
  if (s == null || s.length() == 0) {
    return 0;
  }
  int n = s.length();
  // M[i] represents the number of decode ways of s.substring(i, n);
  int[] M = new int[n + 1];
  // base cases
  M[n] = 1;
  M[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

  for (int i = n - 2; i >= 0; i--) {
    if (s.charAt(i) != '0') {
      M[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? M[i + 1] + M[i + 2] : M[i + 1];
    }
  }
  return M[0];
}

// Method 2
// Time: O(n)
// Space: O(n)
public int numDecodings(String s) {
  // Write your code here
  if (s == null || s.length() == 0) {
    return 0;
  }

  // nums[i] represents the number of decode ways of s.substring(0, i)
  int[] nums = new int[s.length() + 1];
  // Base cases
  nums[0] = 1; // empty string
  nums[1] = s.charAt(0) != '0' ? 1 : 0; // s.length() == 1

  for (int i = 2; i <= s.length(); i++) {
    if (s.charAt(i-1) != '0') {
      nums[i] = nums[i-1];
    }

    int twoDigits = (s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
    if (twoDigits >= 10 && twoDigits <= 26) {
      nums[i] += nums[i-2];
    }
  }

  return nums[s.length()];
}
