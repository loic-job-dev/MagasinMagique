package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagasinMasterTest {
    @Test
    void goldenMaster() {
        Item[] items = new Item[] { new Item("Lego Rathian", 0, 0), //0
                                    new Item("Comté", 5, 48), //1
                                    new Item("Comté", -5, 50), //2
                                    new Item("Kryptonite", 10, 45), //3
                                    new Item("Pass VIP Concert", 45, 4), //4
                                    new Item("Pass VIP Concert", 10, 4), //5
                                    new Item("Pass VIP Concert", 5, 7), //6
                                    new Item("Pass VIP Concert", 0, 47), //7
                                    new Item("Lego Rathian", 4, 4), //8
                                    new Item("Lego Rathian", -4, 4), //9
                                    new Item("Comté", -5, 45),}; //10

        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals("Lego Rathian", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals("Comté", app.items[1].name);
        assertEquals(4, app.items[1].sellIn);
        assertEquals(49, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
        assertEquals("Kryptonite", app.items[3].name);
        assertEquals(10, app.items[3].sellIn);
        assertEquals(45, app.items[3].quality);
        assertEquals("Pass VIP Concert", app.items[4].name);
        assertEquals(44, app.items[4].sellIn);
        assertEquals(5, app.items[4].quality);
        assertEquals(9, app.items[5].sellIn);
        assertEquals(6, app.items[5].quality);
        assertEquals(4, app.items[6].sellIn);
        assertEquals(10, app.items[6].quality);
        assertEquals(-1, app.items[7].sellIn);
        assertEquals(0, app.items[7].quality);
        assertEquals("Lego Rathian", app.items[8].name);
        assertEquals(3, app.items[8].sellIn);
        assertEquals(3, app.items[8].quality);
        assertEquals(-5, app.items[9].sellIn);
        assertEquals(2, app.items[9].quality);
        assertEquals("Comté", app.items[10].name);
        assertEquals(-6, app.items[10].sellIn);
        assertEquals(47, app.items[10].quality);
    }
}
