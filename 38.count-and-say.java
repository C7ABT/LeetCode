/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String res = "1";
        while (--n > 0) {
            String cur = "";
            for (int i = 0; i < res.length(); ++i) {
                int cnt = 1; // We already have a number if matched.
                while ((i + 1 < res.length()) && (res.charAt(i) == res.charAt(i + 1))) {
                    ++cnt;
                    ++i;
                }
                cur += Integer.toString(cnt) + res.charAt(i);   // Add count and num to the cur.
            }
            res = cur;  // "res[j + 1]" should be the calculated "res[j]".
        }
        return res;        
    }
}
// @lc code=end

