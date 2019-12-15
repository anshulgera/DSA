# n pairs given
# n*2 brackets
# opening brackets always <= n
# closing brackets always <=opening brackets

def generate_parenthesis_util(n, opening, closing, string, result):
    if len(string) == n*2:
        result.append(string)
        return
    if opening < n:
        generate_parenthesis_util(n, opening+1, closing, string+'(', result)
    if closing < opening:
        generate_parenthesis_util(n, opening, closing+1, string+')', result)


def generate_parenthesis(n):
    opening = 0
    closing = 0
    result = []
    string = ""
    generate_parenthesis_util(n, opening, closing, string, result)
    print(result)

generate_parenthesis(3)