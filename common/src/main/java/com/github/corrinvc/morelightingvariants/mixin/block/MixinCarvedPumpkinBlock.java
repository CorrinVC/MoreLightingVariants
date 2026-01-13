package com.github.corrinvc.morelightingvariants.mixin.block;

import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Predicate;

@Mixin(CarvedPumpkinBlock.class)
public abstract class MixinCarvedPumpkinBlock {

    @Shadow
    @Final
    @Mutable
    private static Predicate<BlockState> PUMPKINS_PREDICATE;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void adjustPumpkinPredicate(CallbackInfo ci) {
        PUMPKINS_PREDICATE = (blockState) -> blockState != null && blockState.getBlock() instanceof CarvedPumpkinBlock;
    }
}
