package com.p3ng00.morecraftingtables.mixin;

import com.p3ng00.morecraftingtables.MoreCraftingTablesMain;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.stream.Stream;

@Mixin(CraftingScreenHandler.class)
public abstract class CraftingScreenHandlerMixin extends AbstractRecipeScreenHandler<CraftingInventory> {

    @Shadow
    private ScreenHandlerContext context;

    public CraftingScreenHandlerMixin(ScreenHandlerType<?> screenHandlerType, int i) {
        super(screenHandlerType, i);
    }

    @Overwrite
    public boolean canUse(PlayerEntity player) {
        return Stream.of(Blocks.CRAFTING_TABLE, MoreCraftingTablesMain.SPRUCE_CRAFTING_TABLE, MoreCraftingTablesMain.BIRCH_CRAFTING_TABLE, MoreCraftingTablesMain.JUNGLE_CRAFTING_TABLE, MoreCraftingTablesMain.ACACIA_CRAFTING_TABLE, MoreCraftingTablesMain.DARK_OAK_CRAFTING_TABLE, MoreCraftingTablesMain.CRIMSON_CRAFTING_TABLE, MoreCraftingTablesMain.WARPED_CRAFTING_TABLE).anyMatch(block -> !canUse(this.context, player, block));
    }
}
