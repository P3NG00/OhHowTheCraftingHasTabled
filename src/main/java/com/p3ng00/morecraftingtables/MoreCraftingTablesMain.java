package com.p3ng00.morecraftingtables;

import com.p3ng00.morecraftingtables.block.CraftingTableBlock;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreCraftingTablesMain implements ModInitializer {

    public static final String MODID = "morecraftingtables";

    public static final Block SPRUCE_CRAFTING_TABLE = new CraftingTableBlock();
    public static final Block BIRCH_CRAFTING_TABLE = new CraftingTableBlock();
    public static final Block JUNGLE_CRAFTING_TABLE = new CraftingTableBlock();
    public static final Block ACACIA_CRAFTING_TABLE = new CraftingTableBlock();
    public static final Block DARK_OAK_CRAFTING_TABLE = new CraftingTableBlock();
    public static final Block CRIMSON_CRAFTING_TABLE = new CraftingTableBlock();
    public static final Block WARPED_CRAFTING_TABLE = new CraftingTableBlock();

    @Override
    public void onInitialize() {
        register(SPRUCE_CRAFTING_TABLE, "spruce_crafting_table");
        register(BIRCH_CRAFTING_TABLE, "birch_crafting_table");
        register(JUNGLE_CRAFTING_TABLE, "jungle_crafting_table");
        register(ACACIA_CRAFTING_TABLE, "acacia_crafting_table");
        register(DARK_OAK_CRAFTING_TABLE, "dark_oak_crafting_table");
        register(CRIMSON_CRAFTING_TABLE, "crimson_crafting_table");
        register(WARPED_CRAFTING_TABLE, "warped_crafting_table");
    }

    private void register(Block block, String name) {
        Registry.register(Registry.BLOCK, new Identifier(MODID, name), block);
    }
}
