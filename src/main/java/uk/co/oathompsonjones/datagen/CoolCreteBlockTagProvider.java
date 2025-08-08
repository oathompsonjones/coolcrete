package uk.co.oathompsonjones.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import uk.co.oathompsonjones.CoolCrete;
import uk.co.oathompsonjones.CoolCreteBlocks;

import java.util.concurrent.CompletableFuture;

public class CoolCreteBlockTagProvider extends FabricTagProvider<Block> {
    public CoolCreteBlockTagProvider(
            FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture
    ) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        for (String color : CoolCrete.COLORS)
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(CoolCreteBlocks.COOLCRETE_BLOCKS.get(color));
    }
}

