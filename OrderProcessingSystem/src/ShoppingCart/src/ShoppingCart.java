import java.util.Scanner;

public class ShoppingCart {
    Node head;
    Node tail;
    Scanner sc = new Scanner(System.in);
    public void insertAtBeginning(String data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        }
        else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public void insertAtEnd(String data) {
        Node temp = new Node(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    public void addItem(String data, int position) {
        Node temp = new Node(data);
        if (position == 1) {
            insertAtBeginning(data);
        }
        else {
            Node current = head;
            int currPosition = 1;
            while (current != null
                    && currPosition < position) {
                current = current.next;
                currPosition++;
            }
            if (current == null) {
                insertAtEnd(data);
            }
            else {
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
            }
        }
    }

    public void deleteAtBeginning() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    public void deleteAtEnd() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    public void removeItem(int pos) {
        if (head == null) {
            return;
        }

        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count != pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position wrong");
            return;
        }

        if (current == tail) {
            deleteAtEnd();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }
    public void showCart(){
        Node temp = head;
        while(temp != null){
            if (temp.next == null) {
                System.out.println("[" + temp.data + "]-> " + "[null]");
            } else {
                System.out.print("[" + temp.data + "]-> ");
            }
            temp = temp.next;
        }
    }
}
