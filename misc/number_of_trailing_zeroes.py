# first time we divide by number by 5
# we get the number of 5's in the number
# but since 25 has two 5's we need to add 
# extra for every number divisible by 25
# similarly for 625 
class Solution:
    def trailingZeroes(self, n: int) -> int:
        count = 0
        i = 5
        while n>0:
            count += n//i
            n = n // i
        return count