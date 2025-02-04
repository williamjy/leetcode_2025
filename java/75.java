class Solution {
    public void sortColors(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        int i = left, j = mid + 1, k = left;
        while (i < mid + 1 && j <= right) {
            if (numsCopy[i] <= numsCopy[j]) {
                nums[k] = numsCopy[i];
                i++;
            } else {
                nums[k] = numsCopy[j];
                j++;
            }
            k++;
        }
        while (i < mid + 1) {
            nums[k] = numsCopy[i];
            i++;
            k++;
        }
        while (j < right) {
            nums[k] = numsCopy[j];
            j++;
            k++;
        }
    }
}