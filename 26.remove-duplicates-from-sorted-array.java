/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
                /*
                    Use "put" to overcome the deficiency of "move"
                    O(n^2) -> O(n).
                */
            }
        }
        return i + 1;    
    }
}
// @lc code=end

