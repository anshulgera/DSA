# backtracking
# prints duplicates
# n! permutations - takes n time to print one permutation
# O(!n*n)

def permute2_util(s, chosen, res):
    print(f"s {s} : chosen : {chosen}")
    if not s:
        res.append("".join(chosen))
        print("".join(chosen))
    else:
        for i in range(len(s)):
            # choose
            c = s[i]
            chosen.append(c)
            del s[i]

            # explore
            permute2_util(s, chosen, res)

            # unchoose
            s.insert(i, c)
            chosen.pop()

def permute_2(s):
    res = []
    permute2_util(list(s), [], res)
    # print(res)
# --------------------------------------
string = "abc"
permute_2(string)


# another way
def permute_util(s, l, r, res):
    if l==r:
        res.add(''.join(s))
    else:
        for i in range(l,r+1):
            s[l], s[i] = s[i], s[l]
            permute_util(s, l+1, r, res)
            s[l], s[i] = s[i], s[l]

def permute(s, res):
    l, r = 0, len(s)
    permute_util(list(s), l, r-1, res)