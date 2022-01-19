/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1, i = m - 1, j = n - 1;
        /*
            Instead of moving elements,
            we can insert elements from the end of the array.
        */
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[pos] = nums1[i--];
            }   else {
                nums1[pos] = nums2[j--];
            }
            --pos;
        }
        while (i >= 0) {
            nums1[pos] = nums1[i--];
            --pos;
        }
        while (j >= 0) {
            nums1[pos] = nums2[j--];
            --pos;
        }    
    }
}
// @lc code=end

