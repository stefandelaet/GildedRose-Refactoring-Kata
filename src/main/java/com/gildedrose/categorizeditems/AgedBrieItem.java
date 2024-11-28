package com.gildedrose.categorizeditems;

import com.gildedrose.Item;

public class AgedBrieItem  extends CategorizedItem {

    public AgedBrieItem(Item item){
        this(item.name, item.sellIn, item.quality);
    }
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.category = Category.AGEDBRIE;
    }


     // "Aged Brie" actually increases in Quality the older it gets
    @Override
    public void updateQualityImpl() {
        if (quality < MAX_QUALITY) {
            this.quality++;
        }
    }
}
