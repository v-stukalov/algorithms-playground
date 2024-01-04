public class LinkedListCycleStart {

    static class ListNode {
        int value = 0;
        ListNode next;
        ListNode(int value) {
            this.value = value;
        }
    }

    private static int countCycleLength(ListNode slow, ListNode fast) {
        int len = 0;
        do {
            slow = slow.next;
            len++;
        } while (slow != fast);
        return len;
    }

    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                len = countCycleLength(slow, fast);
                break;
            }
        }
        if (len == 0) return null;
        fast = head;
        while (len > 0) {
            fast = fast.next;
            len--;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}