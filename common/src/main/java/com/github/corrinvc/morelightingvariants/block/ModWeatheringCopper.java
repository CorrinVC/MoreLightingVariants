package com.github.corrinvc.morelightingvariants.block;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Optional;

public interface ModWeatheringCopper extends WeatheringCopper {

    static Block getFirst(Block block) {
        Block first = block;
        for(Block b = ModWeatheringStateLists.PREVIOUS_CANDLE_BY_BLOCK.get(block); b != null; b = ModWeatheringStateLists.PREVIOUS_CANDLE_BY_BLOCK.get(b)) {
            first = b;
        }

        return first;
    }

    static Optional<Block> getNext(Block block) {
        return Optional.ofNullable(ModWeatheringStateLists.NEXT_CANDLE_BY_BLOCK.get(block));
    }

    static Optional<Block> getPrevious(Block block) {
        return Optional.ofNullable(ModWeatheringStateLists.PREVIOUS_CANDLE_BY_BLOCK.get(block));
    }

    static Optional<Block> getWaxed(Block block) {
        return Optional.ofNullable(ModWeatheringStateLists.WAXABLES.get(block));
    }

    static Optional<Block> getScraped(Block block) {
        return Optional.ofNullable(ModWeatheringStateLists.SCRAPABLES.get(block));
    }

    static BlockState getFirst(BlockState state) {
        return getFirst(state.getBlock()).withPropertiesOf(state);
    }

    default Optional<BlockState> getNext(BlockState state) {
        return getNext(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    static Optional<BlockState> getPrevious(BlockState state) {
        return getPrevious(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    default Optional<BlockState> canWax(BlockState state) {
        return getWaxed(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    static Optional<BlockState> canScrape(BlockState state) {
        return getScraped(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    default float getChanceModifier() {
        return this.getAge() == WeatheringCopper.WeatherState.UNAFFECTED ? 0.75f : 1.0f;
    }

    default Optional<InteractionResult> useItemOnCopper(ItemStack stack, BlockState state,
                                                        Level level, BlockPos pos, Player player, InteractionHand hand) {
        if(stack.is(ItemTags.AXES) && player.getAbilities().mayBuild) {
            Optional<BlockState> newBlockState = evaluateNewBlockState(level, pos, player, state);
            if(newBlockState.isPresent()) {
                interactionSuccess(stack, level, player, pos, newBlockState.get());

                if(player != null) {
                    stack.hurtAndBreak(1, player, hand);
                }

                return Optional.of(InteractionResult.SUCCESS);
            }
        } else if(stack.is(Items.HONEYCOMB) && player.getAbilities().mayBuild) {
            Optional<BlockState> waxedState = canWax(state);
            if(waxedState.isPresent()) {
                interactionSuccess(stack, level, player, pos, waxedState.get());

                stack.consume(1, player);
                level.levelEvent(player, 3003, pos, 0);

                return Optional.of(InteractionResult.SUCCESS);
            }
        }

        return Optional.empty();
    }

    static void playFanfare(Level level, BlockPos pos, Player player, SoundEvent sound, int event) {
        level.playSound(player, pos, sound, SoundSource.BLOCKS, 1.0f, 1.0f);
        level.levelEvent(player, event, pos, 0);
    }

    static Optional<BlockState> evaluateNewBlockState(Level level, BlockPos pos, Player player, BlockState state) {
        Optional<BlockState> previousState = getPrevious(state);
        if(previousState.isPresent()) {
            playFanfare(level, pos, player, SoundEvents.AXE_SCRAPE, 3005);
            return previousState;
        } else {
            Optional<BlockState> scrapable = canScrape(state);
            if(scrapable.isPresent()) {
                playFanfare(level, pos, player, SoundEvents.AXE_WAX_OFF, 3004);
                return scrapable;
            } else {
                return Optional.empty();
            }
        }
    }

    default void interactionSuccess(ItemStack stack, Level level, Player player, BlockPos pos, BlockState state) {
        if(player instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
        }
        level.setBlock(pos, state, 11);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state));
    }

    class ModWeatheringStateLists {
        public static ImmutableBiMap<Block, Block> NEXT_CANDLE_BY_BLOCK, PREVIOUS_CANDLE_BY_BLOCK;
        public static ImmutableBiMap<Block, Block> WAXABLES, SCRAPABLES;

        public static void initializeBlockMaps() {
            NEXT_CANDLE_BY_BLOCK = new ImmutableBiMap.Builder<Block, Block>()
                    .put(ModBlocks.COPPER_CANDLE, ModBlocks.EXPOSED_COPPER_CANDLE)
                    .put(ModBlocks.EXPOSED_COPPER_CANDLE, ModBlocks.WEATHERED_COPPER_CANDLE)
                    .put(ModBlocks.WEATHERED_COPPER_CANDLE, ModBlocks.OXIDIZED_COPPER_CANDLE)

                    .put(ModBlocks.COPPER_CANDLE_CAKE, ModBlocks.EXPOSED_COPPER_CANDLE_CAKE)
                    .put(ModBlocks.EXPOSED_COPPER_CANDLE_CAKE, ModBlocks.WEATHERED_COPPER_CANDLE_CAKE)
                    .put(ModBlocks.WEATHERED_COPPER_CANDLE_CAKE, ModBlocks.OXIDIZED_COPPER_CANDLE_CAKE)
                    .build();
            PREVIOUS_CANDLE_BY_BLOCK = NEXT_CANDLE_BY_BLOCK.inverse();

            WAXABLES = new ImmutableBiMap.Builder<Block, Block>()
                    .put(ModBlocks.COPPER_CANDLE, ModBlocks.WAXED_COPPER_CANDLE)
                    .put(ModBlocks.EXPOSED_COPPER_CANDLE, ModBlocks.WAXED_EXPOSED_COPPER_CANDLE)
                    .put(ModBlocks.WEATHERED_COPPER_CANDLE, ModBlocks.WAXED_WEATHERED_COPPER_CANDLE)
                    .put(ModBlocks.OXIDIZED_COPPER_CANDLE, ModBlocks.WAXED_OXIDIZED_COPPER_CANDLE)

                    .put(ModBlocks.COPPER_CANDLE_CAKE, ModBlocks.WAXED_COPPER_CANDLE_CAKE)
                    .put(ModBlocks.EXPOSED_COPPER_CANDLE_CAKE, ModBlocks.WAXED_EXPOSED_COPPER_CANDLE_CAKE)
                    .put(ModBlocks.WEATHERED_COPPER_CANDLE_CAKE, ModBlocks.WAXED_WEATHERED_COPPER_CANDLE_CAKE)
                    .put(ModBlocks.OXIDIZED_COPPER_CANDLE_CAKE, ModBlocks.WAXED_OXIDIZED_COPPER_CANDLE_CAKE)
                    .build();
            SCRAPABLES = WAXABLES.inverse();
        }
    }

}
