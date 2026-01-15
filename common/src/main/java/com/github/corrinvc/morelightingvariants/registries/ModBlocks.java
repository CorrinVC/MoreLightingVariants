package com.github.corrinvc.morelightingvariants.registries;

import com.github.corrinvc.morelightingvariants.Constants;
import com.github.corrinvc.morelightingvariants.block.*;
import com.github.corrinvc.morelightingvariants.platform.Services;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.BiConsumer;

public class ModBlocks {

    public static final ResourceKey<Block> COPPER_JACK_O_LANTERN_KEY =
            blockKey("copper_jack_o_lantern");
    public static final ResourceKey<Block> SOUL_JACK_O_LANTERN_KEY =
            blockKey("soul_jack_o_lantern");
    public static final ResourceKey<Block> COPPER_CAMPFIRE_KEY =
            blockKey("copper_campfire");

    public static final ResourceKey<Block> SOUL_CANDLE_KEY =
            blockKey("soul_candle");
    public static final ResourceKey<Block> SOUL_CANDLE_CAKE_KEY =
            blockKey("soul_candle_cake");

    public static final ResourceKey<Block> COPPER_CANDLE_KEY =
            blockKey("copper_candle");
    public static final ResourceKey<Block> EXPOSED_COPPER_CANDLE_KEY =
            blockKey("exposed_copper_candle");
    public static final ResourceKey<Block> WEATHERED_COPPER_CANDLE_KEY =
            blockKey("weathered_copper_candle");
    public static final ResourceKey<Block> OXIDIZED_COPPER_CANDLE_KEY =
            blockKey("oxidized_copper_candle");
    public static final ResourceKey<Block> COPPER_CANDLE_CAKE_KEY =
            blockKey("copper_candle_cake");
    public static final ResourceKey<Block> EXPOSED_COPPER_CANDLE_CAKE_KEY =
            blockKey("exposed_copper_candle_cake");
    public static final ResourceKey<Block> WEATHERED_COPPER_CANDLE_CAKE_KEY =
            blockKey("weathered_copper_candle_cake");
    public static final ResourceKey<Block> OXIDIZED_COPPER_CANDLE_CAKE_KEY =
            blockKey("oxidized_copper_candle_cake_key");

    public static final ResourceKey<Block> WAXED_COPPER_CANDLE_KEY =
            blockKey("waxed_copper_candle");
    public static final ResourceKey<Block> WAXED_EXPOSED_COPPER_CANDLE_KEY =
            blockKey("waxed_exposed_copper_candle");
    public static final ResourceKey<Block> WAXED_WEATHERED_COPPER_CANDLE_KEY =
            blockKey("waxed_weathered_copper_candle");
    public static final ResourceKey<Block> WAXED_OXIDIZED_COPPER_CANDLE_KEY =
            blockKey("waxed_oxidized_copper_candle");
    public static final ResourceKey<Block> WAXED_COPPER_CANDLE_CAKE_KEY =
            blockKey("waxed_copper_candle_cake");
    public static final ResourceKey<Block> WAXED_EXPOSED_COPPER_CANDLE_CAKE_KEY =
            blockKey("waxed_exposed_copper_candle_cake");
    public static final ResourceKey<Block> WAXED_WEATHERED_COPPER_CANDLE_CAKE_KEY =
            blockKey("waxed_weathered_copper_candle_cake");
    public static final ResourceKey<Block> WAXED_OXIDIZED_COPPER_CANDLE_CAKE_KEY =
            blockKey("waxed_oxidized_copper_candle_cake");

    public static final Block COPPER_JACK_O_LANTERN = Services.PLATFORM.getCarvedPumpkinBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.JACK_O_LANTERN)
                    .setId(COPPER_JACK_O_LANTERN_KEY)
    );
    public static final Block SOUL_JACK_O_LANTERN = Services.PLATFORM.getCarvedPumpkinBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.JACK_O_LANTERN)
                    .setId(SOUL_JACK_O_LANTERN_KEY)
                    .lightLevel(level -> 10)
    );
    public static final Block COPPER_CAMPFIRE = new CampfireBlock(
            false, 1,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE)
                    .setId(COPPER_CAMPFIRE_KEY)
    );

    public static final Block SOUL_CANDLE = new SoulCandleBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE).mapColor(MapColor.COLOR_BROWN)
                    .setId(SOUL_CANDLE_KEY)
    );
    public static final Block SOUL_CANDLE_CAKE = new SoulCandleCakeBlock(
            SOUL_CANDLE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE).mapColor(MapColor.COLOR_BROWN)
                    .setId(SOUL_CANDLE_CAKE_KEY)
    );

    public static final Block COPPER_CANDLE = new CopperCandleBlock(
            WeatheringCopper.WeatherState.UNAFFECTED,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE).mapColor(MapColor.COLOR_ORANGE)
                    .setId(COPPER_CANDLE_KEY)
    );
    public static final Block EXPOSED_COPPER_CANDLE = new CopperCandleBlock(
            WeatheringCopper.WeatherState.EXPOSED,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .setId(EXPOSED_COPPER_CANDLE_KEY)
    );
    public static final Block WEATHERED_COPPER_CANDLE = new CopperCandleBlock(
            WeatheringCopper.WeatherState.WEATHERED,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE).mapColor(MapColor.WARPED_STEM)
                    .setId(WEATHERED_COPPER_CANDLE_KEY)
    );
    public static final Block OXIDIZED_COPPER_CANDLE = new CopperCandleBlock(
            WeatheringCopper.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE).mapColor(MapColor.WARPED_NYLIUM)
                    .setId(OXIDIZED_COPPER_CANDLE_KEY)
    );

    public static final Block COPPER_CANDLE_CAKE = new CopperCandleCakeBlock(
            (CopperCandleBlock) COPPER_CANDLE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE).mapColor(MapColor.COLOR_ORANGE)
                    .setId(COPPER_CANDLE_CAKE_KEY)
    );
    public static final Block EXPOSED_COPPER_CANDLE_CAKE = new CopperCandleCakeBlock(
            (CopperCandleBlock) EXPOSED_COPPER_CANDLE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .setId(EXPOSED_COPPER_CANDLE_CAKE_KEY)
    );
    public static final Block WEATHERED_COPPER_CANDLE_CAKE = new CopperCandleCakeBlock(
            (CopperCandleBlock) WEATHERED_COPPER_CANDLE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE).mapColor(MapColor.WARPED_STEM)
                    .setId(WEATHERED_COPPER_CANDLE_CAKE_KEY)
    );
    public static final Block OXIDIZED_COPPER_CANDLE_CAKE = new CopperCandleCakeBlock(
            (CopperCandleBlock) OXIDIZED_COPPER_CANDLE,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE).mapColor(MapColor.WARPED_NYLIUM)
                    .setId(OXIDIZED_COPPER_CANDLE_CAKE_KEY)
    );

    public static final Block WAXED_COPPER_CANDLE = new CopperCandleBlock(
            (CopperCandleBlock) COPPER_CANDLE, WAXED_COPPER_CANDLE_KEY
    );
    public static final Block WAXED_EXPOSED_COPPER_CANDLE = new CopperCandleBlock(
            (CopperCandleBlock) EXPOSED_COPPER_CANDLE, WAXED_EXPOSED_COPPER_CANDLE_KEY
    );
    public static final Block WAXED_WEATHERED_COPPER_CANDLE = new CopperCandleBlock(
            (CopperCandleBlock) WEATHERED_COPPER_CANDLE, WAXED_WEATHERED_COPPER_CANDLE_KEY
    );
    public static final Block WAXED_OXIDIZED_COPPER_CANDLE = new CopperCandleBlock(
            (CopperCandleBlock) OXIDIZED_COPPER_CANDLE, WAXED_OXIDIZED_COPPER_CANDLE_KEY
    );

    public static final Block WAXED_COPPER_CANDLE_CAKE = new CopperCandleCakeBlock(
            (CopperCandleBlock) WAXED_COPPER_CANDLE,
            BlockBehaviour.Properties.ofFullCopy(COPPER_CANDLE_CAKE)
                    .setId(WAXED_COPPER_CANDLE_CAKE_KEY)
    );
    public static final Block WAXED_EXPOSED_COPPER_CANDLE_CAKE = new CopperCandleCakeBlock(
            (CopperCandleBlock) WAXED_EXPOSED_COPPER_CANDLE,
            BlockBehaviour.Properties.ofFullCopy(EXPOSED_COPPER_CANDLE_CAKE)
                    .setId(WAXED_EXPOSED_COPPER_CANDLE_CAKE_KEY)
    );
    public static final Block WAXED_WEATHERED_COPPER_CANDLE_CAKE = new CopperCandleCakeBlock(
            (CopperCandleBlock) WAXED_WEATHERED_COPPER_CANDLE,
            BlockBehaviour.Properties.ofFullCopy(WEATHERED_COPPER_CANDLE_CAKE)
                    .setId(WAXED_WEATHERED_COPPER_CANDLE_CAKE_KEY)
    );
    public static final Block WAXED_OXIDIZED_COPPER_CANDLE_CAKE = new CopperCandleCakeBlock(
            (CopperCandleBlock) WAXED_OXIDIZED_COPPER_CANDLE,
            BlockBehaviour.Properties.ofFullCopy(OXIDIZED_COPPER_CANDLE_CAKE)
                    .setId(WAXED_OXIDIZED_COPPER_CANDLE_CAKE_KEY)
    );

    public static void register(BiConsumer<Block, ResourceKey<Block>> consumer) {
        ModWeatheringCopper.ModWeatheringStateLists.initializeBlockMaps();

        consumer.accept(COPPER_JACK_O_LANTERN, COPPER_JACK_O_LANTERN_KEY);
        consumer.accept(SOUL_JACK_O_LANTERN, SOUL_JACK_O_LANTERN_KEY);
        consumer.accept(COPPER_CAMPFIRE, COPPER_CAMPFIRE_KEY);

        consumer.accept(SOUL_CANDLE, SOUL_CANDLE_KEY);
        consumer.accept(SOUL_CANDLE_CAKE, SOUL_CANDLE_CAKE_KEY);

        consumer.accept(COPPER_CANDLE, COPPER_CANDLE_KEY);
        consumer.accept(EXPOSED_COPPER_CANDLE, EXPOSED_COPPER_CANDLE_KEY);
        consumer.accept(WEATHERED_COPPER_CANDLE, WEATHERED_COPPER_CANDLE_KEY);
        consumer.accept(OXIDIZED_COPPER_CANDLE, OXIDIZED_COPPER_CANDLE_KEY);

        consumer.accept(COPPER_CANDLE_CAKE, COPPER_CANDLE_CAKE_KEY);
        consumer.accept(EXPOSED_COPPER_CANDLE_CAKE, EXPOSED_COPPER_CANDLE_CAKE_KEY);
        consumer.accept(WEATHERED_COPPER_CANDLE_CAKE, WEATHERED_COPPER_CANDLE_CAKE_KEY);
        consumer.accept(OXIDIZED_COPPER_CANDLE_CAKE, OXIDIZED_COPPER_CANDLE_CAKE_KEY);

        consumer.accept(WAXED_COPPER_CANDLE, WAXED_COPPER_CANDLE_KEY);
        consumer.accept(WAXED_EXPOSED_COPPER_CANDLE, WAXED_EXPOSED_COPPER_CANDLE_KEY);
        consumer.accept(WAXED_WEATHERED_COPPER_CANDLE, WAXED_WEATHERED_COPPER_CANDLE_KEY);
        consumer.accept(WAXED_OXIDIZED_COPPER_CANDLE, WAXED_OXIDIZED_COPPER_CANDLE_KEY);

        consumer.accept(WAXED_COPPER_CANDLE_CAKE, WAXED_COPPER_CANDLE_CAKE_KEY);
        consumer.accept(WAXED_EXPOSED_COPPER_CANDLE_CAKE, WAXED_EXPOSED_COPPER_CANDLE_CAKE_KEY);
        consumer.accept(WAXED_WEATHERED_COPPER_CANDLE_CAKE, WAXED_WEATHERED_COPPER_CANDLE_CAKE_KEY);
        consumer.accept(WAXED_OXIDIZED_COPPER_CANDLE_CAKE, WAXED_OXIDIZED_COPPER_CANDLE_CAKE_KEY);
    }

    private static ResourceKey<Block> blockKey(String name) {
        return Constants.makeKey(Registries.BLOCK, name);
    }
}
