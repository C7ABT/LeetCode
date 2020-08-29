/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = new String();
        int len = strs.length;
        int len_0 = strs[0].length();
        for(int i = 0; i < len_0; ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < len; ++j) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;    
    }
}
// @lc code=end

