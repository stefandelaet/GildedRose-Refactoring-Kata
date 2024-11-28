package com.gildedrose;

import com.gildedrose.categorizeditems.CategorizedItem;
import com.gildedrose.categorizeditems.CategorizedItemFactory;

import java.util.List;

public class GildedRose {
    protected List<CategorizedItem> categorizedItems;

    /**
     *
     * @param items Items that are currently in the store.
     */
    public GildedRose(Item... items) {
        this(CategorizedItemFactory.toCategorizedItems(items)); // move items to CategorizedItems that use polymorphism
    }
    // allow for different constructors
    public GildedRose(CategorizedItem... items) {
        this.categorizedItems = List.of(items);
    }
    public GildedRose(List<CategorizedItem> items) {
        this.categorizedItems = items;
    }


    /**
     * Call this function exactly once each day, to recalculate the sellIn and quality properties of all items.
     */
    public void recalculateItems(){
        categorizedItems.forEach(item ->
        {
            item.updateSellIn(); //Use seperate method to update sellIn, to allow different behaviours in different Item subclasses
            item.updateQuality();
        });
    }

    public List<CategorizedItem> getItems() {
        return categorizedItems;
    }


    /**
     * Use {@link #recalculateItems()} function instead. This functions name doesnt say enough.
     */
    @Deprecated()
    public void updateQuality(){
        recalculateItems();
    }


/* // Legacy implementation , keep for now in case of bugs.
    public void updateQualityLegacy() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else { // AGEDBRIE BACKSTAGE
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1; // 2
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1; // 3
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
*/
}
