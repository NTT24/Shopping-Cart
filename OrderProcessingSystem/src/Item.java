public class Item {
    String name;
    int quantity;
    double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public Item(){

    }
    public String toString() {
        return "Item {" + "name='" + name + '\'' + ", quantity=" + quantity + '}' + " ";
    }
}
