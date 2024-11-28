package com.gildedrose.categorizeditems;

import com.gildedrose.Item;

public class NormalItem extends CategorizedItem {

    // keep this configurable
    protected final static int QUALITY_DECREASE_FACTOR = 1;

    public NormalItem(Item item){
        this(item.name, item.sellIn, item.quality);
    }
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.category = Category.NORMAL;
    }

    // At the end of each day our system lowers both values for every item
    // Once the sell in date has passed, Quality degrades twice as fast
    @Override
    public void updateQualityImpl() {
        if (sellIn >= 0 ){
            this.quality-=QUALITY_DECREASE_FACTOR;
        } else {
            this.quality-=2*QUALITY_DECREASE_FACTOR;
        }
    }
}
