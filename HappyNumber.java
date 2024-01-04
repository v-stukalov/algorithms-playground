public class HappyNumber {

    static class ListNode {
        int value = 0;
        ListNode next;
        ListNode(int value) {
            this.value = value;
        }
    }

    private static ListNode nextNode(ListNode head) {
        String number = String.valueOf(head.value);
        int n = 0;
        for (String str : number.split("")) {
            int m = Integer.parseInt(str);
            n += m * m;
        }
        return new ListNode(n);
    }

    public static boolean find(int num) {
        ListNode head = new ListNode(num);
        ListNode slow = head;
        ListNode fast = head;
        ListNode lead = head;

        lead.next = nextNode(head);
        lead.next.next = nextNode(head.next);
        lead = lead.next.next;

        while (fast != null && fast.next != null) {
            if (fast.value == 1)
                return true;
            lead.next = nextNode(lead);
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}