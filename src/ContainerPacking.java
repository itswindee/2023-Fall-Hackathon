import java.util.Stack;

public class ContainerPacking {
    public static void main(String[] args) {
        Container boxTruck = new Container(24, 8, 8, 26000);
        Container shippingContainer = new Container(40, 8.5, 8, 59200);
        Container storageUnit = new Container(20, 8, 10, Double.POSITIVE_INFINITY); // No weight limit for storage unit
        Item pallet = new Item(48, 5, 40, 4600);

        packItems(boxTruck, pallet, 3);
        packItems(shippingContainer, pallet, 4);
        packItems(storageUnit, pallet, 2);

        printContainerContents(boxTruck, "Box Truck");
        printContainerContents(shippingContainer, "Shipping Container");
        printContainerContents(storageUnit, "Storage Unit");
    }

    public static void packItems(Container container, Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (container.canFit(item)) {
                container.items.push(item);
            } else {
                System.out.println("Item does not fit in the container.");
                break;
            }
        }
    }

    public static void printContainerContents(Container container, String containerName) {
        System.out.println(containerName + " Contents:");
        for (Item item : container.items) {
            System.out.println("Item: " + item.length + "x" + item.height + "x" + item.width + ", Weight: " + item.weight);
        }
        System.out.println("Total Weight: " + container.getTotalWeight());
    }
}
