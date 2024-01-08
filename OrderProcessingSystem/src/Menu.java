import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public void displayMenu(){
            System.out.println("----Order Processing System----");
            System.out.println("1.Add Item for Inventory");
            System.out.println("2.Remove Item from Inventory");
            System.out.println("3.Show Inventory");
            System.out.println("4.Add Order");
            System.out.println("5.Remove Order");
            System.out.println("6.Show Order List");
            System.out.println("0.Exit");
    }
    public void handleInput(){
        Order o = new Order();
        int choice = 1;
        while(choice != 0){
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    o.addItem();
                    break;
                case 2:
                    o.removeItem();
                    break;
                case 3:
                    o.showInventory();
                    break;
                case 4:
                    o.addOrder();
                    break;
                case 5:
                    o.removeOrder();
                    break;
                case 6:
                    o.showOrderList();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please choose again");
            }
        }
    }

    public Menu() {
    }
}
