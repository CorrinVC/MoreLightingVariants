package com.github.corrinvc.morelightingvariants.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Optional;

public class CopperCandleCakeBlock extends CandleCakeBlock implements ModWeatheringCopper {

    private final WeatheringCopper.WeatherState weatheringState;

    public CopperCandleCakeBlock(CopperCandleBlock candleBlock, Properties properties) {
        super(candleBlock, properties);
        this.weatheringState = candleBlock.getAge();
    }

    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.changeOverTime(state, level, pos, random);
    }

    protected boolean isRandomlyTicking(BlockState state) {
        return getNext(state).isPresent();
    }

    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                          Player player, InteractionHand hand, BlockHitResult hitResult) {
        Optional<InteractionResult> result = useItemOnCopper(stack, state, level, pos, player, hand);
        return result.orElseGet(() -> super.useItemOn(stack, state, level, pos, player, hand, hitResult));
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(state.getValue(LIT)) {
            this.getParticleOffsets(state).forEach((vec3) ->
                    CopperCandleBlock.addParticlesAndSound(level, vec3.add(pos.getX(), pos.getY(), pos.getZ()), random));
        }
    }

    @Override
    public WeatheringCopper.WeatherState getAge() {
        return this.weatheringState;
    }
}
