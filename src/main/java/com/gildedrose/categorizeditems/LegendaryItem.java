package com.gildedrose.categorizeditems;

import com.gildedrose.Item;

public class LegendaryItem extends CategorizedItem {
    protected final static int LEGENDARYQUALITY = 80;

    public LegendaryItem(Item item){
        this(item.name, item.sellIn, item.quality);
    }

    // Legendary item never has to be sold or decreases in Quality
    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality); // this calls our overriden correctQualityBoundaries()
        this.sellIn = Integer.MAX_VALUE;
        this.category = Category.LEGENDARY;
    }

    @Override
    public void updateQuality() {
        // Never Changes
    }

    @Override
    public void updateQualityImpl() {
        // Never Called
    }

    @Override
    public void updateSellIn() {
        // Never Sold
    }

    @Override
    protected void correctQualityBoundaries() {
        if (this.quality != LEGENDARYQUALITY){
            System.out.println("Warning: Invalid quality value "+this.quality+" for legendary item  "+name+". Setting to "+LEGENDARYQUALITY);
            this.quality = LEGENDARYQUALITY; // Must always be 80
        }
    }
}
