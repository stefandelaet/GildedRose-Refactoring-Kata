package com.gildedrose.categorizeditems;

import com.gildedrose.Item;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class CategorizedItemFactoryTest {


    static Item[] items;


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

    @Test
    void testItemCategorization() {
        List<CategorizedItem> categorizedItems = CategorizedItemFactory.toCategorizedItems(items);
        assertEquals(items.length, categorizedItems.size());
        ListIterator<CategorizedItem> iter = categorizedItems.listIterator();
        assertInstanceOf(NormalItem.class, iter.next());
        assertInstanceOf(NormalItem.class, iter.next());
        assertInstanceOf(NormalItem.class, iter.next());
        assertInstanceOf(AgedBrieItem.class, iter.next());
        assertInstanceOf(NormalItem.class, iter.next());
        assertInstanceOf(LegendaryItem.class, iter.next());
        assertInstanceOf(BackstagePassItem.class, iter.next());
        assertInstanceOf(BackstagePassItem.class, iter.next());
        assertInstanceOf(ConjuredItem.class, iter.next());
    }

    @Test
    void testCategorizationByName() {
        List<Category> categories = Arrays.stream(items).map(item -> CategorizedItemFactory.calculateCategory(item.name)).toList();
        assertEquals(items.length, categories.size());
        ListIterator<Category> iter = categories.listIterator();
        assertEquals(Category.NORMAL, iter.next());
        assertEquals(Category.NORMAL, iter.next());
        assertEquals(Category.NORMAL, iter.next());
        assertEquals(Category.AGEDBRIE, iter.next());
        assertEquals(Category.NORMAL, iter.next());
        assertEquals(Category.LEGENDARY, iter.next());
        assertEquals(Category.BACKSTAGEPASS, iter.next());
        assertEquals(Category.BACKSTAGEPASS, iter.next());
        assertEquals(Category.CONJURED, iter.next());
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
