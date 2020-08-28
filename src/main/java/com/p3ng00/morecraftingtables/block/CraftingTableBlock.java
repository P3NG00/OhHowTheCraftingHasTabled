package com.p3ng00.morecraftingtables.block;

import net.minecraft.block.Blocks;

public class CraftingTableBlock extends net.minecraft.block.CraftingTableBlock {

    public CraftingTableBlock() {
        super(Settings.copy(Blocks.CRAFTING_TABLE));
    }

}
