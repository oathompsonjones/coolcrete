package uk.co.oathompsonjones.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import uk.co.oathompsonjones.CoolCrete;
import uk.co.oathompsonjones.CoolCreteBlocks;

import java.util.Objects;
import java.util.function.Consumer;

public class CoolCreteRecipeProvider extends FabricRecipeProvider {
    public CoolCreteRecipeProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // CoolCrete — packed ice + the correct coloured concrete

        for (String color : CoolCrete.COLORS) {
            // CoolCrete blocks
            Item concrete = CoolCrete.getConcrete(color).asItem();
            Block block   = CoolCreteBlocks.COOLCRETE_BLOCKS.get(color);
            ShapelessRecipeJsonBuilder
                    .create(RecipeCategory.DECORATIONS, block)
                    .input(Items.PACKED_ICE)
                    .input(concrete)
                    .group(Objects.requireNonNull(Identifier.of(CoolCrete.MOD_ID, color + "_coolcrete")).toString())
                    .criterion(FabricRecipeProvider.hasItem(Items.PACKED_ICE),
                            FabricRecipeProvider.conditionsFromItem(Items.PACKED_ICE)
                    )
                    .criterion(FabricRecipeProvider.hasItem(concrete),
                            FabricRecipeProvider.conditionsFromItem(concrete)
                    )
                    .offerTo(exporter, Identifier.of(CoolCrete.MOD_ID, color + "_coolcrete"));
        }
    }
}
