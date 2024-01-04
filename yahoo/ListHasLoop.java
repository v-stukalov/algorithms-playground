package yahoo;

public class ListHasLoop {
    ListNode head;

    public boolean hasLoop() {
        return hasLoop(head);
    }

    private boolean hasLoop(ListNode first) {
        ListNode slow = first;
        ListNode fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
