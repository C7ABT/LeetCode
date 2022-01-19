/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (m.containsKey(temp)) {
                indices[0] = i;
                indices[1] = m.get(temp);
                break;
            }
            m.put(nums[i], i);
            // Put the element inside ##after## the search to avoid overwriting.
        }
        return indices;    
    }
}
// @lc code=end

