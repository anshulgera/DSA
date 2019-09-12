def palindrome(s):
    n = len(s)
    for i in range(0, n-1):
        if s[i] == s[n-1-i]:
            continue
        else:
            return False
    return True

print(palindrome("banana"))