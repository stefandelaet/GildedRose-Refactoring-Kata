package com.gildedrose.categorizeditems;

import com.gildedrose.Item;


public class BackstagePassItem extends CategorizedItem {



    public BackstagePassItem(Item item){
        this(item.name, item.sellIn, item.quality);
    }
    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.category = Category.BACKSTAGEPASS;
    }

    /*
      "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
      Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
      Quality drops to 0 after the concert
     */
    @Override
    public void updateQualityImpl() {
        if(this.sellIn < 0) { //isAfterTheConcert
            this.quality = 0;
        }
        else if(this.quality < MAX_QUALITY) { // concert ticket increases in price, depending on number of days to concert(sellIn)
            this.quality += qualityIncreaseBy(this.sellIn);
        }
    }

    protected Integer qualityIncreaseBy(Integer remainingDaysBeforeConcert) {
        // let s write this really verbose, to improve readability.
        if(remainingDaysBeforeConcert <= 5) {
            return 3;
        }
        else if (remainingDaysBeforeConcert <= 10) {
            return 2;
        }
        else {
            return 1;
        }
    }
}
