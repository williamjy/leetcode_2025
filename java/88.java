class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] nums1Copy = new int[m + n];
        for (i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }
        i = 0;
        while (i < m && j < n) {
            if (nums1Copy[i] < nums2[j]) {
                nums1[i + j] = nums1Copy[i];
                i++;
            } else {
                nums1[i + j] = nums2[j];
                j++;
            }
        }
        while (i < m) {
            nums1[i + j] = nums1Copy[i];
            i++;
        }
        while (j < n) {
            nums1[i + j] = nums2[j];
            j++;
        }
    }
}