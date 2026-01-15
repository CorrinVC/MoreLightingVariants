package com.github.corrinvc.morelightingvariants.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SoulCandleCakeBlock extends CandleCakeBlock {

    public SoulCandleCakeBlock(Block candleBlock, Properties properties) {
        super(candleBlock, properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(state.getValue(LIT)) {
            this.getParticleOffsets(state).forEach((vec3) ->
                    CopperCandleBlock.addParticlesAndSound(level, vec3.add(pos.getX(), pos.getY(), pos.getZ()), random, ParticleTypes.SOUL_FIRE_FLAME));
        }
    }

}
