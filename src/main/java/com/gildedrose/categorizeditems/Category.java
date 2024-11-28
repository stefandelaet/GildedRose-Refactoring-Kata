package com.gildedrose.categorizeditems;

public enum Category {

    /**
     * These #nameId strings are used by #com.gildedrose.categorizeditems.CategorizeditemFactory to assign Item subtype.
     * The order in which these are defined is also the order for the "string contains"- subtyping process.
     */
    CONJURED ("Conjured"),
    BACKSTAGEPASS("Backstage"),
    AGEDBRIE ("Aged Brie"),
    LEGENDARY("Sulfuras"),
    NORMAL (".");
    final String nameId;
    /**
     *
     * @param nameId
     * The String to be contained in a matching Item name.
     */
    Category(String nameId){
        this.nameId = nameId;
    }

    public String getNameId() {
        return nameId;
    }


}
