/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int len_a = a.length() - 1;
        int len_b = b.length() - 1;
        int len = (len_a > len_b) ? len_a : len_b;
        int carry = 0;
        StringBuffer res = new StringBuffer();
        while (len_a >= 0 || len_b >= 0) {
            int x = (len_a >= 0) ? a.charAt(len_a--) - '0' : 0;
            int y = (len_b >= 0) ? b.charAt(len_b--) - '0' : 0;
            int sum = x + y + carry;
            res.append(Integer.toString(sum % 2));
            // res.insert(len + 1, Integer.toString(sum % 2));
            /*
                Previous solution causes REG error,
                can't access position "len + 1".
            */
            carry = sum / 2;
        }
        if (carry == 1) {
            // res.insert(0, "1");
            res.append("1");
        }
        return res.reverse().toString();    
    }
}
// @lc code=end

