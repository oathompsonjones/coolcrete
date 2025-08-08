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
import uk.co.oathompsonjones.Coolcrete;
import uk.co.oathompsonjones.CoolcreteBlocks;

import java.util.Objects;
import java.util.function.Consumer;

public class CoolcreteRecipeProvider extends FabricRecipeProvider {
    public CoolcreteRecipeProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // CoolCrete — packed ice + the correct coloured concrete
        for (String color : Coolcrete.COLORS) {
            Item concrete = Coolcrete.getConcrete(color).asItem();
            Block block   = CoolcreteBlocks.COOLCRETE_BLOCKS.get(color);
            ShapelessRecipeJsonBuilder
                    .create(RecipeCategory.DECORATIONS, block, 2)
                    .input(Items.PACKED_ICE)
                    .input(concrete)
                    .group(Objects
                            .requireNonNull(Identifier.of(Coolcrete.MOD_ID, color + "_coolcrete"))
                            .toString())
                    .criterion(FabricRecipeProvider.hasItem(Items.PACKED_ICE),
                            FabricRecipeProvider.conditionsFromItem(Items.PACKED_ICE)
                    )
                    .criterion(FabricRecipeProvider.hasItem(concrete),
                            FabricRecipeProvider.conditionsFromItem(concrete)
                    )
                    .offerTo(
                            exporter,
                            Identifier.of(Coolcrete.MOD_ID, color + "_coolcrete")
                    );
        }
    }
}
