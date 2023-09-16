import java.util.Scanner;
import java.util.Stack;

public class ContainerPacking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container boxTruck = new Container(24, 8, 8, 26000);
        Container shippingContainer = new Container(40, 8.5, 8, 59200);
        Container storageUnit = new Container(20, 8, 10, Double.POSITIVE_INFINITY);



        //item dimensions
        System.out.println("Please make sure you enter as decimals.");
        System.out.println("Enter the dimensions for the item that needs to be packed in this order: (length height width weight) ");
        double itemLength = scan.nextDouble();
        double itemHeight = scan.nextDouble();
        double itemWidth = scan.nextDouble();
        double itemMaxWeight = scan.nextDouble();
        Item pallet = new Item(itemLength,itemHeight,itemWidth,itemMaxWeight);

        System.out.println("Enter the quantity of items to pack:");
        int quantity = scan.nextInt();

        packItems(boxTruck, pallet, quantity);
        packItems(shippingContainer, pallet, quantity);
        packItems(storageUnit, pallet, quantity);

        printContainerContents(boxTruck, "Box Truck");
        printContainerContents(shippingContainer, "Shipping Container");
        printContainerContents(storageUnit, "Storage Unit");

        scan.close();

    }

    public static void packItems(Container container, Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (container.canFit(item)) {
                container.items.push(item);
            }
            else {
                System.out.println("Item does not fit in the container.");
                break;
            }
        }
    }

    public static void printContainerContents(Container container, String containerName) {
        System.out.println(containerName + " Contents:");
        for (Item item : container.items) {
            System.out.println("Item: " + item.length + " x " + item.height + " x " + item.width + ", Weight: " + item.weight);
        }
        System.out.println("Total Weight: " + container.getTotalWeight());
    }
}

