class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.searchRecursively(nums, target, 0, len(nums) - 1)
    
    def searchRecursively(self, nums: List[int], target: int, left: int, right: int) -> int:
        if left == right:
            if target == nums[left]:
                return left
            else:
                return -1
        if left > right:
            return -1
        mid = int((left + right) / 2)
        if nums[mid] == target:
            return mid
        result = -1
        if nums[left] > nums[mid]:
            curr_result = self.searchRecursively(nums, target, left, mid - 1)
            if curr_result != -1:
                result = curr_result
        else:
            if nums[left] <= target and target < nums[mid]:
                curr_result = self.searchRecursively(nums, target, left, mid - 1)
                if curr_result != -1:
                    result = curr_result

        if nums[mid] > nums[right]:
            curr_result = self.searchRecursively(nums, target, mid + 1, right)
            if curr_result != -1:
                result = curr_result
        else:
            if nums[mid] < target and target <= nums[right]:
                curr_result = self.searchRecursively(nums, target, mid + 1, right)
                if curr_result != -1:
                    result = curr_result
        return result
