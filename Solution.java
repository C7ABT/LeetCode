import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    // 1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (m.containsKey(temp)) {
                indices[0] = i;
                indices[1] = m.get(temp);
                break;
            }
            m.put(nums[i], i);
            // Put the element inside ##after## the search to avoid overwriting.
        }
        return indices;
    }

    // 7. Reverse Integer
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

    // 9. Palindrome Number
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

    // 13. Roman to Integer
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

    // 14. Longest Common Prefix
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

    // 20. Valid Parentheses
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

    // 21. Merge Two Sorted Lists
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        } // Run through one of the list fully.
        cur.next = (l1 == null)?l1:l2; // Link the remnant of the other list.
        return res.next;
    }

    // 26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
                /*
                    Use "put" to overcome the deficiency of "move"
                    O(n^2) -> O(n)
                */
            }
        }
        return i + 1;
    }

    // 27. Remove Element
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    // 28. Implement strStr()
    static public int strStr(String haystack, String needle) {
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

    // 35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int top = nums.length;
        int buttom = 0;
        int mid;
        while (buttom < top) {
            mid = (buttom + top) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                buttom = mid + 1;
            } else {
                top = mid;
            }
        }
        return top;
        // Unlike singly search, here we're required to find the insert position if index not found.
    }

    // 38. Count and Say
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String res = "1";
        while (--n > 0) {
            String cur = "";
            for (int i = 0; i < res.length(); ++i) {
                int cnt = 1; // We already have a number if matched
                while ((i + 1 < res.length()) && (res.charAt(i) == res.charAt(i + 1))) {
                    ++cnt;
                    ++i;
                }
                cur += Integer.toString(cnt) + res.charAt(i);   // add count and num to the cur
            }
            res = cur;  // "res[j + 1]" should be the calculated "res[j]"
        }
        return res;
    }

    // 53. Maximum Subarray

/*
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, cur = 0;
        for (int num : nums) {
            cur = Math.max(cur + num, num);
            res  = Math.max(res, cur);
        }
        return res;
    }
*/
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return helper_maxSubArray(nums, 0, nums.length - 1);
    }
    public int helper_maxSubArray(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int lmax = helper_maxSubArray(nums, left, mid - 1);
        int rmax = helper_maxSubArray(nums, mid + 1, right);
        int cur = nums[mid];
        int temp = cur;
        for (int i = mid - 1; i >= left; --i) {
            temp += nums[i];
            cur = Math.max(cur, temp);
        }
        temp = cur;
        for (int i = mid + 1; i <= right; ++i) {
            temp += nums[i];
            cur = Math.max(cur, temp);
        }
        return Math.max(cur, Math.max(lmax, rmax));
    }

    // 58. Length of Last Word
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

    // 66. Plus One
    static public int[] plusOne(int[] digits) {
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

    // 67. Add Binary
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
                previous solution will cause out_of_range error
            */
            carry = sum / 2;
        }
        if (carry == 1) {
            // res.insert(0, "1");
            res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
    }

}
