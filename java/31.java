class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int index = -1;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i;
                for (int j = i; j < length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        if (nums[j] <= nums[index]) {
                            index = j;
                        }
                    }
                }
                int tmp = nums[i - 1];
                nums[i - 1] = nums[index];
                nums[index] = tmp;
                index = i;
                break;
            }
        }
        if (index == -1) {
            index = 0;
        }
        for (int i = index, j = length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return;
    }
}