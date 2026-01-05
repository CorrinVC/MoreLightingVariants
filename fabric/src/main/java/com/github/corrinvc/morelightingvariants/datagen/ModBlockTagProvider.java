package com.github.corrinvc.morelightingvariants.datagen;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(BlockTags.CAMPFIRES).add(ModBlocks.COPPER_CAMPFIRE);

        valueLookupBuilder(BlockTags.CANDLES)
                .add(ModBlocks.COPPER_CANDLE,
                     ModBlocks.EXPOSED_COPPER_CANDLE,
                     ModBlocks.WEATHERED_COPPER_CANDLE,
                     ModBlocks.OXIDIZED_COPPER_CANDLE,
                     ModBlocks.WAXED_COPPER_CANDLE,
                     ModBlocks.WAXED_EXPOSED_COPPER_CANDLE,
                     ModBlocks.WAXED_WEATHERED_COPPER_CANDLE,
                     ModBlocks.WAXED_OXIDIZED_COPPER_CANDLE);
        valueLookupBuilder(BlockTags.CANDLE_CAKES)
                .add(ModBlocks.COPPER_CANDLE_CAKE,
                     ModBlocks.EXPOSED_COPPER_CANDLE_CAKE,
                     ModBlocks.WEATHERED_COPPER_CANDLE_CAKE,
                     ModBlocks.OXIDIZED_COPPER_CANDLE_CAKE,
                     ModBlocks.WAXED_COPPER_CANDLE_CAKE,
                     ModBlocks.WAXED_EXPOSED_COPPER_CANDLE_CAKE,
                     ModBlocks.WAXED_WEATHERED_COPPER_CANDLE_CAKE,
                     ModBlocks.WAXED_OXIDIZED_COPPER_CANDLE_CAKE);

        valueLookupBuilder(BlockTags.SWORD_EFFICIENT)
                .add(ModBlocks.COPPER_JACK_O_LANTERN,
                     ModBlocks.SOUL_JACK_O_LANTERN);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.COPPER_JACK_O_LANTERN,
                     ModBlocks.SOUL_JACK_O_LANTERN,
                     ModBlocks.COPPER_CAMPFIRE);
    }
}
