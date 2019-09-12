# create stack
# push current node to stack and current = current.left
# if current is null and stack non-empty,
# pop item from stack, print and current=popped_item.right
# till stack is empty


# can be used for various questions like:
#     1. find Kth smallest/largest element in BST
#     2. to validate BST

from node import example_tree


def inorder_iterative(root):
    if not root:
        print("Root is None")
        return 
    stack = list()
    current = root

    while True:
        if current:
            stack.append(current)
            current = current.left
        elif stack:
            current = stack.pop()
            print(current.data)
            current = current.right
        else:
            return

root = example_tree()
inorder_iterative(root)
