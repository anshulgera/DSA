# number of BST's that can be formed using N nodes
# numbered 1,2,3...n
#        i->root
#       / \
#     i-1  n-i
#     X     Y
# total trees = xC1.root.yC1
# f(n) = sum over 1 ot n f(i-1)*f(n-i)
# general formula ->2nCn/n+1
# in case of forming binary trees -> catalan number * n! 