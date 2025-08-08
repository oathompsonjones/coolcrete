package uk.co.oathompsonjones.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import uk.co.oathompsonjones.Coolcrete;

public class CoolcreteEnUsLanguageProvider extends FabricLanguageProvider {
    public CoolcreteEnUsLanguageProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    public static String format(String str) {
        return toTitleCase(str.replace("_", " "));
    }

    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty())
            return str;

        String[]      words     = str.split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty())
                titleCase.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(
                        " ");
        }
        return titleCase.toString().trim();
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for (String color : Coolcrete.COLORS) {
            String newColor = format(color);
            translationBuilder.add("block." + Coolcrete.MOD_ID + "." + color + "_coolcrete", newColor + " Coolcrete");
        }
    }
}

