# 1. consider all substrings of first string 
#     for every substring check if a substring exists in other string
#     keep track of maximum substring O(n*n*m)

# 2. subproblem
#     LCS(X,Y,n,m) = LCS(X,Y,n-1,m-1) + 1 if X[n-1] == Y[m-1]
#       otherwise 0

# Similar to longest common subsequence
# only difference is wehn the characters don't match, 
# we mark cell as 0 as the common substring ends there

n, m = [int(x) for x in input().split()]
stringA = input()
stringB = input()
memo = [[0 for _ in range(n+1)] for _ in range(m+1)]
for i in range(1, m+1):
    for j in range(1, n+1):
        if stringA[j-1] == stringB[i-1]:
            memo[i][j] = memo[i-1][j-1] + 1
        else:
            memo[i][j] = 0
print(max(max(x) for x in memo))