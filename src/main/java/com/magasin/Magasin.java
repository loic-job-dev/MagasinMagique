package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQualityNew() {
        for (Item item : items) {
            if (item.name.equals("Kryptonite")) {
                continue;
            } else if (item.name.equals("Comté")) {
                item.quality = updateComte(item.quality, item.sellIn);
            } else if (item.name.equals("Pass VIP Concert")) {
                item.quality = updatePassVIPConcert(item.quality, item.sellIn);
            } else if (item.name.equals("Pouvoirs magiques")) {
                item.quality = update(item.quality,  item.sellIn);
                item.quality = update(item.quality,  item.sellIn);
            } else if (item.name.equals("Kit lego Monster Hunter")) {
                item.quality = updateKitLegoMonsterHunter(item.quality, item.sellIn);
            }else {
                item.quality = update(item.quality,  item.sellIn);
            }
            item.sellIn--;
        }
    }

    public int update(int quality, int sellIn) {
        if (sellIn < 0) {
            quality = quality -2;
        } else {
            quality--;
        }
        quality = checkQuality(quality);
        return quality;
    }

    public int updateComte(int quality, int sellIn) {
        if (sellIn < 0) {
            quality = quality + 2;
        } else {
            quality++;
        }
        quality = checkQuality(quality);
        return quality;
    }

    public int updatePassVIPConcert(int quality, int sellIn) {
        if (sellIn > 10) {
            quality++;
        }
        else if (sellIn <= 10 && sellIn > 5) {
            quality = quality + 2;
        }
        else if (sellIn <= 5 && sellIn > 0) {
            quality = quality + 3;
        } else {
            quality = 0;
        }
        quality = checkQuality(quality);
        return quality;
    }

    public int updateKitLegoMonsterHunter(int quality, int sellIn) {
        int dizaine = (Math.abs(sellIn) / 10) % 10;
        if (sellIn > 10) {
            if (sellIn > 40) {
                quality = quality + 4;
            } else {
                quality = quality + dizaine;
            }
        } else if (sellIn <= 0) {
            quality = 0;
        }
        quality = checkQuality(quality);
        return quality;
    }

    public int checkQuality(int quality) {
        if (quality < 0) {
            quality = 0;
        }
        if (quality > 50) {
            quality = 50;
        }
        return quality;
    }






    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Comté")
                    && !items[i].name.equals("Pass VIP Concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Kryptonite")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Pass VIP Concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Kryptonite")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Comté")) {
                    if (!items[i].name.equals("Pass VIP Concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Kryptonite")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
