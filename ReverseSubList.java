public class ReverseSubList {
    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q) {
            return head;
        }
        // 1,2,3,4,5; p=2,q=4
        ListNode node = head;
        ListNode prev = null;
        for (int i = 0; node != null && i < p - 1; i++) {
            prev = node;
            node = node.next;
        }
        ListNode before_p = prev; // 1
        ListNode tail = node; // 2
        ListNode next = null;
        for (int i = 0; node != null && i < q - p + 1; i++) { // 4-2+1=3
            next = node.next; // 3
            node.next = prev; //3->1
            prev = node; // 2
            node = next; // 3
        }
        if (before_p != null) {
            before_p.next = prev;
        } else {
            head = prev;
        }
        tail.next = node;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}