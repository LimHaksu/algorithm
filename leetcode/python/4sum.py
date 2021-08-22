class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        ans = []
        s = set()
        for i in range(len(nums)):
            for j in range(i):
                sum_ij = nums[i] + nums[j]
                l = i+1
                r = len(nums)-1
                while l < r:
                    sum_lr = nums[l] + nums[r]
                    if sum_ij + sum_lr == target:
                        s.add((nums[i], nums[j], nums[l], nums[r]))
                        l += 1
                        r -= 1
                    elif sum_ij + sum_lr < target:
                        l += 1
                    elif sum_ij + sum_lr > target:
                        r -= 1
        for (a,b,c,d) in s:
            ans.append([a,b,c,d])
        return ans