// sort array and check adjacent
//  n(n+1)/2 ans subtract sum of array
//  hashing
//  xor

var missingNumber = function(nums) {
    let sum = (nums.length*(nums.length+1))/2;
    for (let i=0;i<nums.length;i++) {
        sum -= nums[i];
    }
    return sum
};