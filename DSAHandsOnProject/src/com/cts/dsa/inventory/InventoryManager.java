package com.cts.dsa.inventory;

import java.util.HashMap;

public class InventoryManager {
    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Add product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("✅ Product added: " + product.getProductName());
    }

    // Update product quantity
    public void updateQuantity(int productId, int newQty) {
        if (inventory.containsKey(productId)) {
            inventory.get(productId).setQuantity(newQty);
            System.out.println("🔁 Quantity updated for product ID: " + productId);
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    // Delete product
    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("🗑️ Product deleted: ID " + productId);
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    // View all products
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("📦 Inventory is empty.");
        } else {
            System.out.println("📋 Inventory List:");
            inventory.values().forEach(System.out::println);
        }
    }
}
