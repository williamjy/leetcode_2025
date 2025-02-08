class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        while (curr < nums.length) {
            if (nums[curr - 1] == nums[curr]) {
                nums[prev] = nums[curr];
                prev++;
                for (; curr < nums.length; curr++) {
                    if (nums[curr] != nums[curr - 1]) {
                        break;
                    }
                }
            } else {
                nums[prev] = nums[curr];
                prev++;
                curr++;
            }
        }
        return prev;
    }
}