package uk.co.oathompsonjones;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import uk.co.oathompsonjones.datagen.*;

public class CoolcreteDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(CoolcreteBlockLootTableProvider::new);
        pack.addProvider(CoolcreteBlockTagProvider::new);
        pack.addProvider(CoolcreteEnGbLanguageProvider::new);
        pack.addProvider(CoolcreteEnUsLanguageProvider::new);
        pack.addProvider(CoolcreteModelProvider::new);
        pack.addProvider(CoolcreteRecipeProvider::new);
    }
}
