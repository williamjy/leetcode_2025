class Solution {
    public boolean search(int[] nums, int target) {
        return searchRecursively(nums, target, 0, nums.length - 1);
    }

    public boolean searchRecursively(int[] nums, int target, int left, int right) {
        if (left == right) {
            return nums[left] == target;
        }
        int mid = (left + right) / 2;
        boolean result = false;
        if (nums[left] >= nums[mid]) {
            result |= searchRecursively(nums, target, left, mid);
        } else {
            if (nums[left] <= target && target <= nums[mid]) {
                result |= searchRecursively(nums, target, left, mid);
            }
        }
        if (nums[mid + 1] >= nums[right]) {
            result |= searchRecursively(nums, target, mid + 1, right);
        } else {
            if (nums[mid + 1] <= target && target <= nums[right]) {
                result |= searchRecursively(nums, target, mid + 1, right);
            }
        }
        return result;
    }
}