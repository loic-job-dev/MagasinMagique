package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Magasin app = new Magasin(items);
        app.updateQualityNew();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void test_quality_speed_sellin_zero() {
        Item[] items = new Item[] { new Item("Steak haché", 2, 4),
                new Item("Jambon cuit", -2, 4)};
        Magasin app = new Magasin(items);
        app.updateQualityNew();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
        assertEquals(-3, app.items[1].sellIn);
        assertEquals(2, app.items[1].quality);
    }

    @Test
    public void test_quality_never_negative() {
        Item[] items = new Item[] { new Item("Steak haché", 2, 0),
                new Item("Jambon cuit", -2, 1)};
        Magasin app = new Magasin(items);
        app.updateQualityNew();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals(-3, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    public void test_comte() {
        Item[] items = new Item[] { new Item("Steak haché", 2, 49),
                new Item("Comté", -2, 49)};
        Magasin app = new Magasin(items);
        app.updateQualityNew();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(48, app.items[0].quality);
        assertEquals(-3, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    public void test_max_quality() {
        Item[] items = new Item[] { new Item("Steak haché", 2, 52),
                new Item("Comté", -2, 50)};
        Magasin app = new Magasin(items);
        app.updateQualityNew();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
        assertEquals(-3, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    public void test_Pass_VIP() {
        Item[] items = new Item[] {new Item ("Pass VIP Concert", -5, 40),
        new Item("Pass VIP Concert", 90, 45),
        new Item("Pass VIP Concert", 9, 40),
        new Item("Pass VIP Concert", 4, 30),};

        Magasin app = new Magasin(items);

        app.updateQualityNew();

        assertEquals(-6, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals(89, app.items[1].sellIn);
        assertEquals(46, app.items[1].quality);
        assertEquals(8, app.items[2].sellIn);
        assertEquals(42, app.items[2].quality);
        assertEquals(3, app.items[3].sellIn);
        assertEquals(33, app.items[3].quality);
    }

    @Test
    public void test_Pouvoirs_magiques  () {
        Item[] items = new Item[] {new Item ("Pouvoirs magiques", -5, 40),
                new Item("Pouvoirs magiques", 90, 45)};

        Magasin app = new Magasin(items);

        app.updateQualityNew();

        assertEquals(-6, app.items[0].sellIn);
        assertEquals(36, app.items[0].quality);
        assertEquals(89, app.items[1].sellIn);
        assertEquals(43, app.items[1].quality);
    }

}
