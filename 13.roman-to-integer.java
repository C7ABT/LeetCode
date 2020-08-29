/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        int res = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            int temp = m.get(s.charAt(i));
            if (i == len - 1 || m.get(s.charAt(i + 1)) <= temp ) {
                res += temp;
            } else {
                res -= temp;
            }
        }
        return res;    
    }
}
// @lc code=end

