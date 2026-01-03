package com.github.corrinvc.morelightingvariants.block;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Optional;

public interface ModWeatheringCopper extends ChangeOverTimeBlock<WeatheringCopper.WeatherState> {

    static Optional<Block> getNext(Block block) {
        return Optional.ofNullable(ModWeatheringStateLists.NEXT_CANDLE_BY_BLOCK.get(block));
    }

    static Optional<Block> getPrevious(Block block) {
        return Optional.ofNullable(ModWeatheringStateLists.PREVIOUS_CANDLE_BY_BLOCK.get(block));
    }

    default Optional<BlockState> getNext(BlockState state) {
        return getNext(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    default Optional<BlockState> getPrevious(BlockState state) {
        return getPrevious(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    default float getChanceModifier() {
        return this.getAge() == WeatheringCopper.WeatherState.UNAFFECTED ? 0.75f : 1.0f;
    }

    default Optional<InteractionResult> useAxeOn(ItemStack stack, BlockState state,
                                                 Level level, BlockPos pos, Player player, InteractionHand hand) {
        if(stack.is(ItemTags.AXES) && player.getAbilities().mayBuild) {
            Optional<BlockState> previousState = getPrevious(state);
            if(previousState.isPresent()) {
                playFanfare(level, pos, player, state);

                if(player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, stack);
                }

                level.setBlock(pos, previousState.get(), 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, previousState.get()));
                if(player != null) {
                    stack.hurtAndBreak(1, player, hand);
                }

                return Optional.of(InteractionResult.SUCCESS);
            }
        }

        return Optional.empty();
    }

    default void playFanfare(Level level, BlockPos pos, Player player, BlockState state) {
        level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0f, 1.0f);
        level.levelEvent(player, 3005, pos, 0);
    }

    class ModWeatheringStateLists {
        public static ImmutableBiMap<Block, Block> NEXT_CANDLE_BY_BLOCK, PREVIOUS_CANDLE_BY_BLOCK;

        public static void initializeBlockMaps() {
            NEXT_CANDLE_BY_BLOCK = new ImmutableBiMap.Builder<Block, Block>()
                    .put(ModBlocks.COPPER_CANDLE, ModBlocks.EXPOSED_COPPER_CANDLE)
                    .put(ModBlocks.EXPOSED_COPPER_CANDLE, ModBlocks.WEATHERED_COPPER_CANDLE)
                    .put(ModBlocks.WEATHERED_COPPER_CANDLE, ModBlocks.OXIDIZED_COPPER_CANDLE)
                    .build();
            PREVIOUS_CANDLE_BY_BLOCK = new ImmutableBiMap.Builder<Block, Block>()
                    .put(ModBlocks.EXPOSED_COPPER_CANDLE, ModBlocks.COPPER_CANDLE)
                    .put(ModBlocks.WEATHERED_COPPER_CANDLE, ModBlocks.EXPOSED_COPPER_CANDLE)
                    .put(ModBlocks.OXIDIZED_COPPER_CANDLE, ModBlocks.WEATHERED_COPPER_CANDLE)
                    .build();
        }
    }

}
