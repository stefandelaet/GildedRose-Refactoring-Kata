package com.gildedrose;

import com.gildedrose.categorizeditems.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class CategorizedItemFactoryTest {


    static Item[] items;


    @Test
    void testItemCategorization() {
        List<CategorizedItem> categorizedItems = CategorizedItemFactory.toCategorizedItems(items);
        int i = 0;
        assertInstanceOf(NormalItem.class, categorizedItems.get(i++));
        assertInstanceOf(NormalItem.class, categorizedItems.get(i++));
        assertInstanceOf(NormalItem.class, categorizedItems.get(i++));
        assertInstanceOf(AgedBrieItem.class, categorizedItems.get(i++));
        assertInstanceOf(NormalItem.class, categorizedItems.get(i++));
        assertInstanceOf(LegendaryItem.class, categorizedItems.get(i++));
        assertInstanceOf(BackstagePassItem.class, categorizedItems.get(i++));
        assertInstanceOf(BackstagePassItem.class, categorizedItems.get(i++));
        assertInstanceOf(ConjuredItem.class, categorizedItems.get(i++));
    }



    @BeforeAll
    static void initAll() {
        items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("", 10, 20), //
            new Item(null, 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a Aged Brie concert with Sulfuras", 15, 20),
            new Item("Conjured Mana Cake", 3, 6) };
    }



    @BeforeEach
    void init() {
    }


    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
