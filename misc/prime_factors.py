import math

def prime_factors(n):
    result = []
    while n%2 == 0:
        result.append(2)
        n = n/2
    
    for i in range(3, int(math.sqrt(n))+1, 2):
        while n%i == 0:
            result.append(i)
            n = n/i
    if n>2:
        result.append(int(n))
    return result

print(prime_factors(63))
