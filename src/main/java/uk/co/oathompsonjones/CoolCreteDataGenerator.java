package uk.co.oathompsonjones;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import uk.co.oathompsonjones.datagen.*;

public class CoolCreteDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(CoolCreteBlockLootTableProvider::new);
        pack.addProvider(CoolCreteBlockTagProvider::new);
        pack.addProvider(CoolCreteEnGbLanguageProvider::new);
        pack.addProvider(CoolCreteEnUsLanguageProvider::new);
        pack.addProvider(CoolCreteModelProvider::new);
        pack.addProvider(CoolCreteRecipeProvider::new);
    }
}
