# Approach 1: get inorder traversal, it should be sorted
# Approach 2: checking subtrees using range 

from node import example_tree

# clamping window
def isValidBST(node, l, r):
    if not node:
        return True
    return l < node.data < r and isValidBST(node.left, l, node.data) and isValidBST(node.right, node.data, r)

def validate_BST(node):
    if not node:
        return True
    return isValidBST(node, float('-inf'), float('inf'))

root = example_tree()
result = validate_BST(root)
print(result)
