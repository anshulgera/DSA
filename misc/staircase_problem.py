# N stairs
# can take 1 step, 2 steps, 3 steps at one time
# Number of ways to reach N

# Subproblem
# At n -> ans(n-1) + ans(n-2) + ans(n-3)
# if n<3, answer is trivial
# n = 0 or n = 1, ans is 1
# n = 2 ans is 2
# n = 3 ans is 4
# construct answer using this subproblems

def ways(n):
    if n == 0 or n == 1:
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 4
    return ways(n-1) + ways(n-2) + ways(n-3)

print(ways(4))