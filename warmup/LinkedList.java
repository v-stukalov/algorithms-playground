package warmup;

public class LinkedList {
    private Node head;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.printList();

        linkedList.reverseBetween(1, 3);
//        linkedList.reverse();
        linkedList.printList();
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print("->" + temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    // WRITE THE REVERSEBETWEEN METHOD HERE //
    //                                      //
    //                                      //
    //                                      //
    //                                      //
    //////////////////////////////////////////
    public void reverseBetween(int m, int n) {
        Node pre = skip(m);
        Node node = pre != null ? pre.next : head;
        Node next;
        int l = n-m+1;
        while (l-->0 && node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        head = pre;
    }

    public Node skip(int n) {
        if (n == 0 || n >= length) return null;

        Node pre = head;
        Node node = pre.next;
        for (int i = 1; i < n; i++) {
            pre = node;
            node = node.next;
        }
        return pre;
    }

    public Node reverse() {
        Node pre = null;
        Node node = head;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        head = pre;
        return pre;
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
