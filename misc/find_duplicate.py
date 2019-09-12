# sorting and check adjacent numbers if duplicate
# set
# idea same as linked list cycle, to find the point of start of loop
# mark indexes of numbers that we have visited as index=num-1 as we start from 1...n

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        for num in nums:
            if nums[abs(num)-1]>0:
                nums[abs(num)-1] = -nums[abs(num)-1]
            else:
                return abs(num)
