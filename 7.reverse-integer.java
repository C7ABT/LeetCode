/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int pop = 0;
        int rev = 0;
        int MAX_VALUE = Integer.MAX_VALUE / 10;
        int MIN_VALUE = Integer.MIN_VALUE / 10;
        while (x != 0) {
            pop = x % 10;
            x /= 10;
            if (rev > MAX_VALUE || (rev == MAX_VALUE && pop > 7)) {
                return 0;
            }
            else if (rev < MIN_VALUE || (rev == MIN_VALUE && pop < -8)) {
                return 0;
            }
            rev *= 10;
            rev += pop;
        }
        return rev;    
    }
}
// @lc code=end

