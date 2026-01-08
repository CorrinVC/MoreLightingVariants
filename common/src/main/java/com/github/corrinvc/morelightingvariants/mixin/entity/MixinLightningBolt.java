package com.github.corrinvc.morelightingvariants.mixin.entity;

import com.github.corrinvc.morelightingvariants.block.ModWeatheringCopper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(LightningBolt.class)
public abstract class MixinLightningBolt {

    @Inject(method = "clearCopperOnLightningStrike",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;setBlockAndUpdate(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z",
                    shift = At.Shift.AFTER
            ))
    private static void convertToModWeatheringCopper(Level level, BlockPos pos, CallbackInfo info) {
        BlockState state = level.getBlockState(pos);
        if(state.getBlock() instanceof ModWeatheringCopper) {
            level.setBlockAndUpdate(pos, ModWeatheringCopper.getFirst(state));
        }
    }

    @Inject(method = "randomStepCleaningCopper",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/Optional;ifPresent(Ljava/util/function/Consumer;)V",
                    shift = At.Shift.AFTER
            ))
    private static void randomStepModWeatheringCopper(Level level, BlockPos pos, CallbackInfoReturnable<Optional<BlockPos>> info) {
        BlockState state = level.getBlockState(pos);
        if(state.getBlock() instanceof ModWeatheringCopper) {
            ModWeatheringCopper.getPrevious(state).ifPresent((bs) -> level.setBlockAndUpdate(pos, bs));
        }
    }


}
