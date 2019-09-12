/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    let memo = new Array(text2.length+1).fill(0).map(() => new Array(text1.length+1).fill(0));
    for (var i=1; i<=text2.length;i++) {
        for (var j=1; j<=text1.length; j++) {
            if (text1[j-1] === text2[i-1]) {
                console.log(text1[i-1]);
                memo[i][j] = memo[i-1][j-1] + 1;
            } else {
                memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
            }
        }
    }
    return memo[i-1][j-1];
};