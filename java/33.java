class Solution {
    public int search(int[] nums, int target) {
        return searchRecursively(nums, target, 0, nums.length - 1);
    }

    public int searchRecursively(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        int result = -1;
        if (((nums[start] < nums[mid]) && (nums[start] <= target && target <= nums[mid])) || (nums[start] > nums[mid])) {
            int leftResult = searchRecursively(nums, target, start, mid - 1);
            if (leftResult != -1) {
                result = leftResult;
            }
        }
        if (((nums[mid] < nums[end]) && (nums[mid] <= target && target <= nums[end])) || (nums[mid] > nums[end])) {
            int rightResult = searchRecursively(nums, target, mid + 1, end);
            if (rightResult != -1) {
                result = rightResult;
            }
        }
        return result;
    }
}