package com.gildedrose.categorizeditems;

import com.gildedrose.Item;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * Factory to instantiate the correct CategorizedItem(s), given the name of the item.
 */
public class CategorizedItemFactory {

    // Get all Categories without having to maintain a list.
    protected final static List<Category> ALLCATEGORIES = Arrays.asList(Category.class.getEnumConstants());

    public static List<CategorizedItem> toCategorizedItems(Item... items){
        return Arrays.stream(items).map(CategorizedItemFactory::toCategorizedItem).toList();
    }

    public static CategorizedItem toCategorizedItem(Item item){
        Category category = calculateCategory(item.name);
        switch (category){
            case LEGENDARY -> {
                return new LegendaryItem(item);
            }
            case AGEDBRIE -> {
                return new AgedBrieItem(item);
            }
            case CONJURED -> {
                return new ConjuredItem(item);
            }
            case BACKSTAGEPASS -> {
                return new BackstagePassItem(item);
            }
        }
        return new NormalItem(item);
    }

    /*
    Calculate Category depending on the give Item name. Uses a string contains on subsequential category nameIds.
     */
    protected static Category calculateCategory(String name) {
        Optional<Category> cat =  ALLCATEGORIES.stream().filter(category -> name != null && name.contains(category.getNameId())).findFirst();
        //TODO Or do a case insensitive string contains with org.apache.commons.lang3.StringUtils.containsIgnoreCase() ?
        return cat.orElse(Category.NORMAL);
    }
}
