package com.p3ng00.morecraftingtables;

import com.p3ng00.morecraftingtables.block.CraftingTableBlock;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreCraftingTablesMain implements ModInitializer {

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
        Identifier id = new Identifier("morecraftingtables", name);
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().group(ItemGroup.DECORATIONS)));
    }
}
