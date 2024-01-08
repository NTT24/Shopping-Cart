import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    Node front, rear;
    int count = 0;
    Scanner sc = new Scanner(System.in);
    ArrayList<Item> inventory = new ArrayList<>();
    public void remove(Node node, int index) {
        Node temp = front;
        Node prev = front;
        for (int i = 0; i < index; i++) {
            if (i == 0 && index == 1) {
                node = node.next;
                front = node;
            } else {
                if (i == index - 1 && temp != null) {
                    prev.next = temp.next;
                } else {
                    prev = temp;
                    if (prev == null) break;
                    temp = temp.next;
                }
            }
        }
    }
    public void removeOrder(){
        showOrderList();
        System.out.print("Enter name of order to remove: ");
        String name = sc.nextLine();
        Node temp = front;
        int index = 1;
        while(front != null){
            if(temp.data.equals(name)){
                remove(temp,index);
                System.out.println("Order removed");
                break;
            }
            else {
                temp = temp.next;
                index++;
            }
        }
    }
    public void addOrder() {
        System.out.print("Enter name: ");
        String data = sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        for(Item i : inventory){
            if(i.getName().equals(data) && i.getQuantity() >= quantity){
                System.out.println("Ordered");
                i.setQuantity(i.getQuantity() - quantity);
                Node newNode = new Node(data);
                if (this.rear == null) {
                    this.front = this.rear = newNode;
                    return;
                }
                this.rear.next = newNode;
                this.rear = newNode;
                count++;
            }
            else if(i.getName().equals(data) && i.getQuantity() < quantity){
                System.out.println("Out of order, only have " + i.getQuantity() + " " + i.getName());
            }
        }
    }
    public void showOrderList(){
        Node temp = front;
        while(temp != null){
            if (temp.next == null) {
                System.out.println("[" + temp.data + "]-> " + "[null]");
            } else {
                System.out.print("[" + temp.data + "]-> ");
            }
            temp = temp.next;
        }
    }

    public void addItem(){
        System.out.print("Input name: ");
        String name = sc.nextLine();
        System.out.print("Input quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        Item item = new Item(name,quantity);
        inventory.add(item);
        System.out.println("Added successfully");
    }
    public void removeItem(){
        showInventory();
        System.out.print("Enter name of item to remove: ");
        String name = sc.nextLine();
        for(Item i : inventory){
            if(i.getName().equals(name)){
                inventory.remove(i);
                System.out.println("Item removed");
                break;
            }
        }
    }
    public void showInventory(){
        for(Item i : inventory){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
