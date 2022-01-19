/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int len_h = haystack.length();
        int len_n = needle.length();
        if (len_h < len_n)  return -1;
        for (int i = 0; i <= len_h - len_n; ++i) {
            int j = 0;
            for (j = 0; j < len_n; ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == len_n) {
                return i;
            }
        }
        return -1;    
    }
}
// @lc code=end

