package com.magasin;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenMasterTest {

    private String itemsToString(Item[] items) {
        return Arrays.stream(items)
                .map(i -> i.name + ", " + i.sellIn + ", " + i.quality)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Test
    void goldenMaster() throws IOException {
        Item[] items = new Item[]{
                new Item("foo", 0, 0),
                new Item("Comté", 5, 48),
                new Item("Comté", -5, 50),
                new Item("Kryptonite", 10, 45),
                new Item("Pass VIP Concert", 45, 4),
                new Item("Pass VIP Concert", 10, 4),
                new Item("Pass VIP Concert", 5, 7),
                new Item("Pass VIP Concert", 0, 47),
                new Item("Lego Rathian", 4, 4),
                new Item("Lego Rathian", -4, 4),
                new Item("Comté", -5, 45)
        };

        Magasin app = new Magasin(items);


        for (int i = 0; i <5; i++) {
            app.updateQualityNew();
            //System.out.println("Résultat au jour " + (i+1) + " :\n");
            for (Item item : items) {
                //System.out.println(item);
            }
            //System.out.println("\n\n");
        }

        // Transformation en String
        String resultat = itemsToString(app.items);

        // Chemin du fichier Golden Master
        Path goldenMasterPath = Path.of("src/test/resources/goldenMaster.txt");

        if (!Files.exists(goldenMasterPath)) {
            // 1ère exécution → on génère le Golden Master
            Files.writeString(goldenMasterPath, resultat);
            System.out.println("Golden Master créé !");
        }

        // Lecture du Golden Master existant
        String attendu = Files.readString(goldenMasterPath);

        // Comparaison
        assertEquals(attendu, resultat, "La sortie ne correspond pas au Golden Master");
    }
}