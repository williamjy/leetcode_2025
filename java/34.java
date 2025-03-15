class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1 && nums[0] != target) {
            return result;
        }
        int[] searchResult = searchRangeRecursively(nums, target, 0, nums.length - 1);
        if (searchResult[0] > searchResult[1]) {
            return result;
        }
        return searchResult;
    }

    public int[] searchRangeRecursively(int[] nums, int target, int start, int end) {
        int[] result = new int[2];
        result[0] = nums.length - 1;
        result[1] = 0;
        if (start > end) {
            return result;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            result[0] = mid;
            result[1] = mid;
        }
        if (target <= nums[mid]) {
            int[] leftResult = searchRangeRecursively(nums, target, start, mid - 1);
            if (leftResult[0] <= result[0]) {
                result[0] = leftResult[0];
            }
            if (leftResult[1] >= result[1]) {
                result[1] = leftResult[1];
            }
        }
        if (target >= nums[mid]) {
            int[] rightResult = searchRangeRecursively(nums, target, mid + 1, end);
            if (rightResult[0] <= result[0]) {
                result[0] = rightResult[0];
            }
            if (rightResult[1] >= result[1]) {
                result[1] = rightResult[1];
            }
        }
        return result;
    }
}