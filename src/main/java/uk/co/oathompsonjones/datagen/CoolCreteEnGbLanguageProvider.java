package uk.co.oathompsonjones.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import uk.co.oathompsonjones.CoolCrete;

public class CoolCreteEnGbLanguageProvider extends FabricLanguageProvider {
    public CoolCreteEnGbLanguageProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_gb");
    }

    public static String correctSpelling(String str) {
        return str.replace("gray", "grey");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for (String color : CoolCrete.COLORS) {
            String newColor = CoolCreteEnUsLanguageProvider.format(correctSpelling(color));
            translationBuilder.add("block." + CoolCrete.MOD_ID + "." + color + "_coolcrete", newColor + " CoolCrete");
        }
    }
}

