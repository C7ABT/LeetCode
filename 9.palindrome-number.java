/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) { // Obviously -xxx or xxx0 can't be a palindrome.
            return false;
        } else {
            int pop = 0;
            int rev = 0;
            int MAX_VALUE = Integer.MAX_VALUE / 10;
            int temp = x;
            while (x != 0) {
                pop = x % 10;
                x /= 10;
                if (rev > MAX_VALUE || (rev == MAX_VALUE && pop > 7)) {
                    return false;
                }
                rev *= 10;
                rev += pop;
            }
            if (temp == rev) {
                return true;
            }
            else {
                return false;
            }
        }    
    }
}
// @lc code=end

