public class ReverseInGroups {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head = null;
    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    public Node reverseInGroups(Node head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        Node prev = null;
        Node current = head;
        Node next = null;
        int count = 0;
        
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        
        if (next != null) {
            head.next = reverseInGroups(next, k);
        }
        
        return prev;
    }
    
    public void reverseGroups(int k) {
        head = reverseInGroups(head, k);
    }
    
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ReverseInGroups list = new ReverseInGroups();
        
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        
        System.out.println("Original list:");
        list.display();
        
        list.reverseGroups(3);
        
        System.out.println("After reversing in groups of 3:");
        list.display();
    }
}
