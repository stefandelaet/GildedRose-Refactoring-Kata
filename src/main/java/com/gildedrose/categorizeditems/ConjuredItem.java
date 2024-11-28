package com.gildedrose.categorizeditems;

import com.gildedrose.Item;

public class ConjuredItem extends NormalItem {
    public ConjuredItem(Item item){
        this(item.name, item.sellIn, item.quality);
    }
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.category = Category.CONJURED;
    }

    /*
     * SPEC: Conjured items degrade in Quality twice as fast as NormalItem.
     * Since behaviour of NormalItem may change, we must not provide an implementation here, but instead call NormalItem.updateQualityImpl twice..
     */
    @Override
    public void updateQualityImpl() {
       super.updateQualityImpl();
       super.updateQualityImpl();
    }

}
