package com.p3ng00.morecraftingtables;

import com.p3ng00.morecraftingtables.block.CraftingTableBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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
        registerCraftingTable(SPRUCE_CRAFTING_TABLE, "spruce_crafting_table", true);
        registerCraftingTable(BIRCH_CRAFTING_TABLE, "birch_crafting_table", true);
        registerCraftingTable(JUNGLE_CRAFTING_TABLE, "jungle_crafting_table", true);
        registerCraftingTable(ACACIA_CRAFTING_TABLE, "acacia_crafting_table", true);
        registerCraftingTable(DARK_OAK_CRAFTING_TABLE, "dark_oak_crafting_table", true);
        registerCraftingTable(CRIMSON_CRAFTING_TABLE, "crimson_crafting_table", false);
        registerCraftingTable(WARPED_CRAFTING_TABLE, "warped_crafting_table", false);
    }

    private void registerCraftingTable(Block craftingTable, String name, boolean fuel) {

        Identifier id = new Identifier("morecraftingtables", name);

        Registry.register(Registry.BLOCK, id, craftingTable);
        Registry.register(Registry.ITEM, id, new BlockItem(craftingTable, new Item.Settings().group(ItemGroup.DECORATIONS)));

        if (fuel)
            FuelRegistry.INSTANCE.add(craftingTable, 300);

    }
}
