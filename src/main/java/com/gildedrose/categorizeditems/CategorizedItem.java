package com.gildedrose.categorizeditems;

import com.gildedrose.Item;

/**
 * Base class for Items with a fixed Category.
 * Each subclass uses Polymorphism to define its own required behaviour.
 * Quality updating function {@link #updateQualityImpl()} is mandatory in order to Subclass.
 * This class already defines some constructor corrections and applies quality boundaries rules
 */
public abstract class CategorizedItem extends Item {


    Category category;
    protected final int MAX_QUALITY = 50;

    /**
     *
     * @param name  name of the item, which also defines its behaviour.
     * @param sellIn the number of days we have to sell the item
     * @param quality how valuable the item is
     */
    public CategorizedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        if (this.name == null) {
            this.name = "";
        }
        correctQualityBoundaries();
    }

    /**
     * Use seperate method to update sellIn, to allow different behaviours in different subclasses
     */
    public void updateSellIn(){
        this.sellIn --;
    }

    /**
     * Use seperate method to update quality, to allow different behaviours in different subclasses
     */
    public void updateQuality(){
        updateQualityImpl();
        correctQualityBoundaries();
    }

    public abstract void updateQualityImpl();


    protected void correctQualityBoundaries(){
        if (this.quality < 0) {
            //System.out.println("Warning: Invalid negative quality value for item  "+name+". Setting to 0");
            this.quality = 0;
        } else if (this.quality > MAX_QUALITY) {
            //System.out.println("Warning: Invalid positive quality value for item  "+name+". Setting to "+MAX_QUALITY);
            this.quality = MAX_QUALITY;
        }

    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof CategorizedItem item){
            return
                item.name.equals(this.name) &&
                item.sellIn == this.sellIn &&
                item.quality == this.quality &&
                item.category == this.category;
        }
        return false;
    }
}
