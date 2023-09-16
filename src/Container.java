import java.util.Stack;

class Container {
    double length;
    double height;
    double width;
    double maxWeight;
    Stack<Item> items;

    public Container(double length, double height, double width, double maxWeight) {
        this.length = length;
        this.height = height;
        this.width = width;
        this.maxWeight = maxWeight;
        this.items = new Stack<>();
    }

    public boolean canFit(Item item) {
        return (this.length >= item.length &&
                this.height >= item.height &&
                this.width >= item.width &&
                this.getTotalWeight() + item.weight <= this.maxWeight);
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.weight;
        }
        return totalWeight;
    }
}
