/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        digits[len] += 1;
        if (digits[len] != 10) {
            return digits;
        }
        int i = len;
        boolean flag = false;
        while (digits[i] == 10) {
            digits[i] = 0;
            if (i == 0) {
                flag = true;
                break;
            }
            digits[--i] += 1;
        }
        if (flag) {
            int[] res = new int[len + 2];
            res[0] = 1;
            for (int j = 1; j < len + 2; ++j) {
                res[j] = 0;
            }
            return res;
        }
        return digits;    
    }
}
// @lc code=end

