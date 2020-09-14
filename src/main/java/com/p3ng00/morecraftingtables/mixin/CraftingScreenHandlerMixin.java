package com.p3ng00.morecraftingtables.mixin;

import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CraftingScreenHandler.class)
public abstract class CraftingScreenHandlerMixin extends AbstractRecipeScreenHandler<CraftingInventory> {

    /*
     *  Taken from Paulevs 'Better Nether'
     */

    @Shadow
    private ScreenHandlerContext context;

    public CraftingScreenHandlerMixin(ScreenHandlerType<?> screenHandlerType, int i) {
        super(screenHandlerType, i);
    }

    @Inject(at = @At("HEAD"), method = "canUse", cancellable = true)
    public void canUse(PlayerEntity player, CallbackInfoReturnable<Boolean> info) {

        info.setReturnValue(context.run((world, blockPos) -> world.getBlockState(blockPos).getBlock() instanceof CraftingTableBlock, true));
        info.cancel();

    }
}
