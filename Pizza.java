/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InheritanceActivity;

import java.util.ArrayList;
import java.util.List;

class Pizza {
    private final String description;
    private final double basePrice;
    private final List<Item> items;

    public Pizza(String description, double basePrice) {
        this.description = description;
        this.basePrice = basePrice;
        this.items = new ArrayList<>();
    }

    public void addTopping(String name, double price) {
        items.add(new Item(name, price));
    }

    public void addAddon(String name, double price) {
        items.add(new Item(name, price));
    }

    public List<Item> getItems() {
        return items;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getDescription() {
        return description;
    }

    public double getTotalPrice() {
        return basePrice + items.stream().mapToDouble(Item::getPrice).sum();
    }
}

