package com.github.corrinvc.morelightingvariants.datagen;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider {

    protected ModLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder builder) {
        builder.add(ModBlocks.COPPER_JACK_O_LANTERN, "Copper Jack o'Lantern");
        builder.add(ModBlocks.SOUL_JACK_O_LANTERN, "Soul Jack o'Lantern");
        builder.add(ModBlocks.COPPER_CAMPFIRE, "Copper Campfire");

        builder.add(ModBlocks.COPPER_CANDLE, "Copper Candle");
        builder.add(ModBlocks.EXPOSED_COPPER_CANDLE, "Exposed Copper Candle");
        builder.add(ModBlocks.WEATHERED_COPPER_CANDLE, "Weathered Copper Candle");
        builder.add(ModBlocks.OXIDIZED_COPPER_CANDLE, "Oxidized Copper Candle");

        builder.add(ModBlocks.WAXED_COPPER_CANDLE, "Waxed Copper Candle");
        builder.add(ModBlocks.WAXED_EXPOSED_COPPER_CANDLE, "Waxed Exposed Copper Candle");
        builder.add(ModBlocks.WAXED_WEATHERED_COPPER_CANDLE, "Waxed Weathered Copper Candle");
        builder.add(ModBlocks.WAXED_OXIDIZED_COPPER_CANDLE, "Waxed Oxidized Copper Candle");
    }
}
