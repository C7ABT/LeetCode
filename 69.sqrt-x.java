/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0, right = x;
        while (left < right) {
            int mid = (left + right) / 2;
            // if (x >= mid * mid) {
            /*
                Previous solution causes TLE error,
                (mid * mid) might exceed range of Integer.
            */
            if (x / mid >= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;    
    }
}
// @lc code=end

