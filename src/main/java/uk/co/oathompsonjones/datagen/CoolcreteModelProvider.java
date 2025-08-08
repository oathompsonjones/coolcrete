package uk.co.oathompsonjones.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import uk.co.oathompsonjones.Coolcrete;
import uk.co.oathompsonjones.CoolcreteBlocks;

public class CoolcreteModelProvider extends FabricModelProvider {
    public CoolcreteModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (String color : Coolcrete.COLORS) {
            blockStateModelGenerator.registerSingleton(
                    CoolcreteBlocks.COOLCRETE_BLOCKS.get(color),
                    new TextureMap().put(TextureKey.ALL, new Identifier("minecraft", "block/" + color + "_concrete")),
                    TexturedModel.CUBE_ALL.get(Coolcrete.getConcrete(color)).getModel()
            );
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
