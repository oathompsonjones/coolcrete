package uk.co.oathompsonjones.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import uk.co.oathompsonjones.CoolCrete;
import uk.co.oathompsonjones.CoolCreteBlocks;

public class CoolCreteModelProvider extends FabricModelProvider {
    public CoolCreteModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (String color : CoolCrete.COLORS) {
            blockStateModelGenerator.registerSingleton(
                    CoolCreteBlocks.COOLCRETE_BLOCKS.get(color),
                    new TextureMap().put(TextureKey.ALL, new Identifier("minecraft", "block/" + color + "_concrete")),
                    TexturedModel.CUBE_ALL.get(CoolCrete.getConcrete(color)).getModel()
            );
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
