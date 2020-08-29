/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int i = 0;
        int j = 0;
        for (j = s.length() - 1; j >= 0; --j) {
            i = j;
            while ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                --i;
                if (i == -1 || s.charAt(i) == ' ') {
                    return j - i;
                }
            }
        }
        return 0;    
    }
}
// @lc code=end

