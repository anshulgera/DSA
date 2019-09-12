# brute force
# manacher's algo
# dp

def longest_palindrome_substring(s):
    memo = [[0 for _ in range(len(s)+1)] for _ in range(len(s)+1)]
    n = len(s)
    for i in range(1, n+1):
        for j in range(1, n+1):
            if s[i-1] == s[j-1]:
                print(f" i char equals j char {s[i-1]} {s[j-1]}")
                memo[i][j] = memo[i-1][j-1] + 1
            else:
                memo[i][j] = max(memo[i-1][j], memo[i][j-1])
    print(memo[-1][-1])
    print(memo)
longest_palindrome_substring("anshul")
