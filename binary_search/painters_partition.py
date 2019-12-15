class Solution:
    # @param A : integer
    # @param B : integer
    # @param C : list of integers
    # @return an integer
    def is_valid(self, A, B, C, mid):
        
        painters = 1
        total_length = 0
        
        for num in C:
            if total_length+num <= mid:
                total_length += num
            else:
                total_length = num
                painters += 1
                if painters > A:
                    return False
        return True
    
    def paint(self, A, B, C):
        total_sum = 0
        max_length = 0
        for num in C:
            total_sum += num
            max_length = max(max_length, num)
        min_value = max_length
        max_value = total_sum
        result = 0
        while min_value <= max_value:
            mid = min_value + (max_value - min_value)//2
            if self.is_valid(A, B, C, mid):
                result = mid
                max_value = mid-1
            else:
                min_value = mid+1
        return (result*B)%10000003