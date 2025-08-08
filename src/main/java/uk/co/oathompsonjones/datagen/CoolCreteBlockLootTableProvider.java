package uk.co.oathompsonjones.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import uk.co.oathompsonjones.CoolCrete;
import uk.co.oathompsonjones.CoolCreteBlocks;

public class CoolCreteBlockLootTableProvider extends FabricBlockLootTableProvider {
    public CoolCreteBlockLootTableProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        for (String color : CoolCrete.COLORS) {
            addDrop(CoolCreteBlocks.COOLCRETE_BLOCKS.get(color));
        }
    }
}
