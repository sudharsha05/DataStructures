public class DeleteKthElement {
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
    
    public void deleteKth(int k) {
        if (head == null || k <= 0) {
            return;
        }
        
        if (k == 1) {
            head = head.next;
            return;
        }
        
        Node temp = head;
        for (int i = 1; i < k - 1 && temp != null; i++) {
            temp = temp.next;
        }
        
        if (temp == null || temp.next == null) {
            return;
        }
        
        temp.next = temp.next.next;
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
        DeleteKthElement list = new DeleteKthElement();
        
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        
        System.out.println("Original list:");
        list.display();
        
        list.deleteKth(3);
        
        System.out.println("After deleting 3rd element:");
        list.display();
    }
}
