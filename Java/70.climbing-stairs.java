/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        /*
            Using recursion causes TLE error.
        */
        int [] result = new int [n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i < n + 1; ++i) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];    
    }
}
// @lc code=end

