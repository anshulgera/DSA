# Approach 1: divide the problem => sum of all nodes equals
#             = current node data + leftsubtree sum + rightsubtree sum
# Apporach 2: level order traversal
# Approach 3: Iterative traversal-pre, in, post

from node import example_tree

def preorder(root):
    if root:
        print(root.data, end=", ")
        preorder(root.left)
        preorder(root.right)

def sum_of_all_nodes_inorder(node):
    if not root:
        print("Root is None")
        return 
    stack = list()
    current = root
    total = 0
    while True:
        if current:
            stack.append(current)
            current = current.left
        elif stack:
            current = stack.pop()
            total += current.data
            current = current.right
        else:
            return total

def sum_of_all_nodes(node):
    if not node:
        return 0
    return node.data + sum_of_all_nodes(node.left) + sum_of_all_nodes(node.right)

# ----------------------
# construct tree
root = example_tree()
s = sum_of_all_nodes(root)
print(f"from sum of all nodes {s}")
s = sum_of_all_nodes_inorder(root)
print(f"from sum of all nodes inorder {s}")