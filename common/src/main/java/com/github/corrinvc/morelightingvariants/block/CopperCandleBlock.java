package com.github.corrinvc.morelightingvariants.block;

import com.github.corrinvc.morelightingvariants.registries.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class CopperCandleBlock extends CandleBlock implements ModWeatheringCopper {

    private final WeatheringCopper.WeatherState weatheringState;

    public CopperCandleBlock(CopperCandleBlock candleBlock, ResourceKey<Block> id) {
        this(candleBlock.getAge(), BlockBehaviour.Properties.ofFullCopy(candleBlock).setId(id));
    }

    public CopperCandleBlock(WeatheringCopper.WeatherState weatheringState, Properties properties) {
        super(properties);
        this.weatheringState = weatheringState;
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
        Optional<InteractionResult> result = useItemOnCopper(stack, state, level, pos, player, hand);
        return result.orElseGet(() -> super.useItemOn(stack, state, level, pos, player, hand, hitResult));
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(state.getValue(LIT)) {
            this.getParticleOffsets(state).forEach((vec3) ->
                    addParticlesAndSound(level, vec3.add(pos.getX(), pos.getY(), pos.getZ()), random));
        }
    }

    public static void addParticlesAndSound(Level level, Vec3 offset, RandomSource random) {
        float f = random.nextFloat();
        if(f < 0.3f) {
            level.addParticle(ParticleTypes.SMOKE, offset.x, offset.y, offset.z, 0.0f, 0.0f, 0.0f);
            if(f < 0.17f) {
                level.playLocalSound(offset.x + (double) 0.5f, offset.y + (double) 0.5f, offset.z + (double) 0.0f,
                        SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0f + random.nextFloat(),
                        random.nextFloat() * 0.7f + 0.3f, false);
            }
        }

        level.addParticle(ModParticles.COPPER_FLAME, offset.x, offset.y, offset.z, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public WeatheringCopper.WeatherState getAge() {
        return this.weatheringState;
    }
}
