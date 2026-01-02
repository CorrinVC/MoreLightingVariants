package com.github.corrinvc.morelightingvariants.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class ModWeatheringCopper implements WeatheringCopper {

//    @Override
//    default void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
//        this.changeOverTime(state, level, pos, random);
//    }

    @Override
    public WeatherState getAge() {
        return null;
    }
}
