// Trien khai danh sach lien ket trong Java

class LinkedList {
    // Tao mot nut
    Node head;

    static class Node {
        int value;
        Node next;

        Node(int d) {
            value = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Gan gia tri cho cac nut
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        // Ket noi cac nut
        linkedList.head.next = second;
        second.next = third;

        // In gia tri nut
        while (linkedList.head != null) {
            System.out.print(linkedList.head.value + " ");
            linkedList.head = linkedList.head.next;
        }
    }
}
