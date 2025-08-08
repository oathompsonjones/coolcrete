package uk.co.oathompsonjones.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import uk.co.oathompsonjones.Coolcrete;
import uk.co.oathompsonjones.CoolcreteBlocks;

public class CoolcreteBlockLootTableProvider extends FabricBlockLootTableProvider {
    public CoolcreteBlockLootTableProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        for (String color : Coolcrete.COLORS) {
            addDrop(CoolcreteBlocks.COOLCRETE_BLOCKS.get(color));
        }
    }
}
