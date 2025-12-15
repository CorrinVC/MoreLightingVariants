package com.github.corrinvc.morelightingvariants.registries;

import com.github.corrinvc.morelightingvariants.Constants;
import com.github.corrinvc.morelightingvariants.platform.Services;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class ModBlocks {

    public static final ResourceKey<Block> COPPER_JACK_O_LANTERN_KEY =
            blockKey("copper_jack_o_lantern");
    public static final ResourceKey<Block> SOUL_JACK_O_LANTERN_KEY =
            blockKey("soul_jack_o_lantern");
    public static final ResourceKey<Block> COPPER_CAMPFIRE_KEY =
            blockKey("copper_campfire");

    public static final Block COPPER_JACK_O_LANTERN = Services.PLATFORM.getCarvedPumpkinBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.JACK_O_LANTERN)
                    .setId(SOUL_JACK_O_LANTERN_KEY)
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

    public static void register(BiConsumer<Block, ResourceKey<Block>> consumer) {
        consumer.accept(COPPER_JACK_O_LANTERN, COPPER_JACK_O_LANTERN_KEY);
        consumer.accept(SOUL_JACK_O_LANTERN, SOUL_JACK_O_LANTERN_KEY);
        consumer.accept(COPPER_CAMPFIRE, COPPER_CAMPFIRE_KEY);
    }

    private static ResourceKey<Block> blockKey(String name) {
        return Constants.makeKey(Registries.BLOCK, name);
    }
}
