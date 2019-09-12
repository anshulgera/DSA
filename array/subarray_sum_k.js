/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, k) {
    let cummulativeSum = {};
    let sumSoFar = 0;
    cummulativeSum[0] = 1;
    let count = 0;
    for (let i=0;i<nums.length;i++) {
        sumSoFar += nums[i];
        if ((sumSoFar-k) in cummulativeSum) {
            count += cummulativeSum[sumSoFar-k]
        } 
        if (sumSoFar in cummulativeSum) {
            cummulativeSum[sumSoFar]++;
        } else {
            cummulativeSum[sumSoFar] = 1;
        }
    }
    return count;
};