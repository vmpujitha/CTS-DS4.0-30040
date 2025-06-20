package com.cts.dsa.inventory;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Product p1 = new Product(101, "Mouse", 30, 499.0);
        Product p2 = new Product(102, "Keyboard", 20, 999.0);
        Product p3 = new Product(103, "Monitor", 10, 7499.0);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);

        manager.displayInventory();

        manager.updateQuantity(102, 25);
        manager.deleteProduct(101);

        System.out.println("\n📦 Updated Inventory:");
        manager.displayInventory();
    }
}
