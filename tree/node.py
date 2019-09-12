class Node:
    def __init__(self, data):
        self.data = data
        self.left = self.right = None
    
def example_tree():
    root = Node(15)
    root.left = Node(10)
    root.right = Node(20)
    root.left.left = Node(8)
    root.left.right = Node(12)
    root.right.left = Node(16)
    root.right.right = Node(25)
    # root.right.right.right = Node(1)
    return root