/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int top = nums.length;
        int buttom = 0;
        int mid;
        while (buttom < top) {
            mid = (buttom + top) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                buttom = mid + 1;
            } else {
                top = mid;
            }
        }
        return top;
        // Unlike singly search, here we're required to find the insert position if index not found.    
    }
}
// @lc code=end

