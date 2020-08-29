/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)   return true;
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                boolean flag = stack.isEmpty();
                if (flag)   return false;
                if (c == ')' && stack.peek() != '(')    return false;
                if (c == ']' && stack.peek() != '[')    return false;
                if (c == '}' && stack.peek() != '{')    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();    
    }
}
// @lc code=end

