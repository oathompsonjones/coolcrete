package uk.co.oathompsonjones;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Coolcrete implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_NAME = "Coolcrete";
    public static final String MOD_ID   = MOD_NAME.toLowerCase();
    public static final Logger LOGGER   = LoggerFactory.getLogger(MOD_ID);

    public static final String[] COLORS = {
            "white",
            "light_gray",
            "gray",
            "black",
            "brown",
            "red",
            "orange",
            "yellow",
            "lime",
            "green",
            "cyan",
            "light_blue",
            "blue",
            "purple",
            "magenta",
            "pink"
    };

    public static Block getConcrete(String color) {
        HashMap<String, Block> map = new HashMap<String, Block>();
        map.put("white", Blocks.WHITE_CONCRETE);
        map.put("light_gray", Blocks.LIGHT_GRAY_CONCRETE);
        map.put("gray", Blocks.GRAY_CONCRETE);
        map.put("black", Blocks.BLACK_CONCRETE);
        map.put("brown", Blocks.BROWN_CONCRETE);
        map.put("red", Blocks.RED_CONCRETE);
        map.put("orange", Blocks.ORANGE_CONCRETE);
        map.put("yellow", Blocks.YELLOW_CONCRETE);
        map.put("lime", Blocks.LIME_CONCRETE);
        map.put("green", Blocks.GREEN_CONCRETE);
        map.put("cyan", Blocks.CYAN_CONCRETE);
        map.put("light_blue", Blocks.LIGHT_BLUE_CONCRETE);
        map.put("blue", Blocks.BLUE_CONCRETE);
        map.put("purple", Blocks.PURPLE_CONCRETE);
        map.put("magenta", Blocks.MAGENTA_CONCRETE);
        map.put("pink", Blocks.PINK_CONCRETE);
        return map.get(color);
    }

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("{} is initializing!", MOD_ID);

        // Register all items, item groups and blocks
        CoolcreteBlocks.initialize();
    }
}