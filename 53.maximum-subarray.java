/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return helper_maxSubArray(nums, 0, nums.length - 1);
    }
    public int helper_maxSubArray(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int lmax = helper_maxSubArray(nums, left, mid - 1);
        int rmax = helper_maxSubArray(nums, mid + 1, right);
        int cur = nums[mid];
        int temp = cur;
        for (int i = mid - 1; i >= left; --i) {
            temp += nums[i];
            cur = Math.max(cur, temp);
        }
        temp = cur;
        for (int i = mid + 1; i <= right; ++i) {
            temp += nums[i];
            cur = Math.max(cur, temp);
        }
        return Math.max(cur, Math.max(lmax, rmax));
    }
}
// @lc code=end

