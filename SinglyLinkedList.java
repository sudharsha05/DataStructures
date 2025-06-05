public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head = null;
    
    public void insertAtBeg(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    public void insertAtPos(int data, int pos) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            insertAtBeg(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 1; current != null && i < pos - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position exceeds list size.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    
    public void deleteAtBeg() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }
    
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    
    public void deleteAtPos(int pos) {
        if (pos <= 0 || head == null) {
            System.out.println("Invalid operation.");
            return;
        }
        if (pos == 1) {
            deleteAtBeg();
            return;
        }
        Node current = head;
        for (int i = 1; current != null && i < pos - 1; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        current.next = current.next.next;
    }
    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeg(15);
        list.insertAtEnd(25);
        list.insertAtBeg(5);
        list.insertAtPos(20, 2);
        list.display();
        list.deleteAtBeg();
        list.display();
        list.deleteAtEnd();
        list.display();
        list.deleteAtPos(2);
        list.display();
    }
}
