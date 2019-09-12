# factors of a number
import math


def factors(n):
    for i in range(1, n+1):
        if n%i == 0:
            print(i)

def factors_improved(n):
    for i in range(1, int(math.sqrt(n))):
        if n%i == 0:
            print(i)
            print(int(n/i))

factors(50)
factors_improved(50)