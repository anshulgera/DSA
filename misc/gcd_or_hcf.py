# Approach 1: find all primes factors of a and b, the take intersection of those 2

from prime_factors import prime_factors

def get_intersection(list_1, list_2):
    return [val for val in list_1 if val in list_2]

def get_gcd(a, b):
    pf_a = prime_factors(a)
    pf_b = prime_factors(b)
    print(pf_a)
    print(pf_b)
    intersection = get_intersection(pf_a, pf_b)
    if not intersection:
        print(1)
    else:
        print(intersection)
    
def get_gcd_2(a, b):
    if b == 0:
        return a
    return get_gcd_2(b, a%b)

get_gcd(10, 19)
print(get_gcd_2(10, 19))