# always move slow after we ensure that fast moves twice
class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or head.next is None:
            return None
        
        slow = head
        fast = head
        while fast.next:
            fast = fast.next
            if fast.next:
                fast = fast.next
                slow = slow.next
            if fast==slow:
                break
        if fast==slow:
            slow = head
            while fast!=slow:
                fast = fast.next
                slow = slow.next
            return slow
        return None