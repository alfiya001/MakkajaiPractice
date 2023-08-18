package example;
public class Item {
public final String name;
public final Itemtype cat;
public final boolean isImported;
public final float basePrice;

public Item(String name, Itemtype cat, boolean isImported, float price) {
    this.name = name;
    this.cat = cat;
    this.isImported = isImported;
    this.basePrice = price;
}
}