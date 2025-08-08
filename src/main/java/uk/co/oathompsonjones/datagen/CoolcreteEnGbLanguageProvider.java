package uk.co.oathompsonjones.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import uk.co.oathompsonjones.Coolcrete;

public class CoolcreteEnGbLanguageProvider extends FabricLanguageProvider {
    public CoolcreteEnGbLanguageProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_gb");
    }

    public static String correctSpelling(String str) {
        return str.replace("gray", "grey");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for (String color : Coolcrete.COLORS) {
            String newColor = CoolcreteEnUsLanguageProvider.format(correctSpelling(color));
            translationBuilder.add("block." + Coolcrete.MOD_ID + "." + color + "_coolcrete", newColor + " Coolcrete");
        }
    }
}

