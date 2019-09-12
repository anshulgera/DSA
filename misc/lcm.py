# a*b = LCM(a,b) * GCD(a,b)

def get_gcd(a, b):
    if b == 0:
        return a
    if a>b:
        return get_gcd(b, a%b)
    else:
        return get_gcd(a, b%a)

def get_lcm(a, b):
    gcd = get_gcd(a, b)
    lcm = (a*b)/gcd
    print(lcm)

get_lcm(10, 21)