package com.gildedrose;

import com.gildedrose.categorizeditems.NormalItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategorizedItemTest {


    @Test
    public void testInvalidCtrValuesCorrection(){
        NormalItem item = new NormalItem(null,-45, -6);
        assertEquals(new NormalItem("",-45, 0),  item);
        item = new NormalItem("vsmpovmqwomewt908435tr2",800, 75);
        assertEquals(new NormalItem("vsmpovmqwomewt908435tr2",800, 50),  item);
    }
}
