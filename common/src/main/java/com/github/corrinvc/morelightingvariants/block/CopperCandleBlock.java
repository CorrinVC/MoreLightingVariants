package com.github.corrinvc.morelightingvariants.block;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Optional;

public class CopperCandleBlock extends CandleBlock implements WeatheringCopper {

    public static ImmutableBiMap<Block, Block> NEXT_CANDLE_BY_BLOCK, PREVIOUS_CANDLE_BY_BLOCK;

    private final WeatheringCopper.WeatherState weatheringState;

    public CopperCandleBlock(WeatheringCopper.WeatherState weatheringState, Properties properties) {
        super(properties);
        this.weatheringState = weatheringState;
    }

    public static void initializeBlockMaps() {
        NEXT_CANDLE_BY_BLOCK = new ImmutableBiMap.Builder<Block, Block>()
                .put(ModBlocks.COPPER_CANDLE, ModBlocks.EXPOSED_COPPER_CANDLE)
                .put(ModBlocks.EXPOSED_COPPER_CANDLE, ModBlocks.WEATHERED_COPPER_CANDLE)
                .build();
        PREVIOUS_CANDLE_BY_BLOCK = new ImmutableBiMap.Builder<Block, Block>()
                .put(ModBlocks.EXPOSED_COPPER_CANDLE, ModBlocks.COPPER_CANDLE)
                .put(ModBlocks.WEATHERED_COPPER_CANDLE, ModBlocks.EXPOSED_COPPER_CANDLE)
                .build();
    }

    private static Optional<Block> getNextCandle(BlockState state) {
        if(state.is(ModBlocks.COPPER_CANDLE)) return Optional.of(ModBlocks.EXPOSED_COPPER_CANDLE);
        else return Optional.empty();
    }

    static Optional<Block> getNext(Block block) {
        System.out.println(Optional.ofNullable(NEXT_CANDLE_BY_BLOCK.get(block)));
        return Optional.ofNullable(NEXT_CANDLE_BY_BLOCK.get(block));
    }

    @Override
    public Optional<BlockState> getNext(BlockState state) {
        return getNext(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }


    private Optional<BlockState> getPrevious(BlockState state) {
        return Optional.ofNullable(PREVIOUS_CANDLE_BY_BLOCK.get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }

    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.changeOverTime(state, level, pos, random);
    }

    protected boolean isRandomlyTicking(BlockState state) {
        System.out.println("COPPER CANDLE RANDOMLY TICKING: " + getNext(state).isPresent());
        return getNext(state).isPresent();
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(stack.is(ItemTags.AXES) && player.getAbilities().mayBuild) {
            Optional<BlockState> optional = this.getPrevious(state);
            if(optional.isPresent()) {
                playFanfare(level, pos, player, state, SoundEvents.AXE_SCRAPE, 3005);

                if(player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, stack);
                }

                level.setBlock(pos, optional.get(), 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, optional.get()));
                if(player != null) {
                    stack.hurtAndBreak(1, player, hand.asEquipmentSlot());
                }

                return InteractionResult.SUCCESS;
            }
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    private void playFanfare(Level level, BlockPos pos, Player player, BlockState state, SoundEvent sound, int event) {
        level.playSound(player, pos, sound, SoundSource.BLOCKS, 1.0f, 1.0f);
        level.levelEvent(player, event, pos, 0);
    }

    @Override
    public WeatherState getAge() {
        return this.weatheringState;
    }
}
