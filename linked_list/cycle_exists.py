class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# always move slow after we ensure that fast moves twice
class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if not head or head.next is None:
            return False
        slow = fast = head
        while fast.next:
            fast = fast.next
            if fast.next:
                fast = fast.next
                slow = slow.next
            if fast == slow:
                return True
        return False