package uk.co.oathompsonjones;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CoolcreteBlocks {
    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            Identifier.of(Coolcrete.MOD_ID, "item_group")
    );

    public static final Map<String, Block> COOLCRETE_BLOCKS = Arrays.stream(Coolcrete.COLORS).collect(Collectors.toMap(color -> color,
            color -> register(new Block(AbstractBlock.Settings
                    .copy(Blocks.PACKED_ICE)
                    .mapColor(DyeColor.byName(color, DyeColor.WHITE))
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.8F)
                    .sounds(BlockSoundGroup.STONE)), color + "_coolcrete")
    ));

    public static Block register(Block block, String name) {
        return register(block, name, () -> new BlockItem(block, new Item.Settings()));
    }

    public static Block register(Block block, String name, Supplier<Item> itemSupplier) {
        Identifier id = new Identifier(Coolcrete.MOD_ID, name);

        if (itemSupplier != null) {
            Registry.register(Registries.ITEM, id, itemSupplier.get());
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP,
                ITEM_GROUP,
                FabricItemGroup
                        .builder()
                        .icon(() -> new ItemStack(COOLCRETE_BLOCKS.get("magenta")))
                        .displayName(Text.of(Coolcrete.MOD_NAME))
                        .build()
        );

        // Register all the blocks in the item group
        for (String color : Coolcrete.COLORS)
            ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register((group) -> group.add(COOLCRETE_BLOCKS
                    .get(color)
                    .asItem()));
    }
}