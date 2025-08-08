package uk.co.oathompsonjones.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import uk.co.oathompsonjones.Coolcrete;
import uk.co.oathompsonjones.CoolcreteBlocks;

import java.util.concurrent.CompletableFuture;

public class CoolcreteBlockTagProvider extends FabricTagProvider<Block> {
    public CoolcreteBlockTagProvider(
            FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture
    ) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        for (String color : Coolcrete.COLORS)
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(CoolcreteBlocks.COOLCRETE_BLOCKS.get(color));
    }
}

