package com.p3ng00.morecraftingtables.mixin;

import com.p3ng00.morecraftingtables.MoreCraftingTablesMain;
import net.minecraft.block.Blocks;
import net.minecraft.container.BlockContext;
import net.minecraft.container.ContainerType;
import net.minecraft.container.CraftingContainer;
import net.minecraft.container.CraftingTableContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.stream.Stream;

@Mixin(CraftingTableContainer.class)
public abstract class CraftingTableContainerMixin extends CraftingContainer<CraftingInventory> {

    public CraftingTableContainerMixin(ContainerType<?> containerType, int i) {
        super(containerType, i);
    }

    @Shadow
    private BlockContext context;

    public boolean canUse(PlayerEntity player) {
        return Stream.of(Blocks.CRAFTING_TABLE, MoreCraftingTablesMain.SPRUCE_CRAFTING_TABLE, MoreCraftingTablesMain.BIRCH_CRAFTING_TABLE, MoreCraftingTablesMain.JUNGLE_CRAFTING_TABLE, MoreCraftingTablesMain.ACACIA_CRAFTING_TABLE, MoreCraftingTablesMain.DARK_OAK_CRAFTING_TABLE).anyMatch(block -> canUse(context, player, block));
    }
}
