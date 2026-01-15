package com.github.corrinvc.morelightingvariants.datagen;

import com.github.corrinvc.morelightingvariants.registries.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(ItemTags.CANDLES)
                .add(ModItems.SOUL_CANDLE,
                     ModItems.COPPER_CANDLE,
                     ModItems.EXPOSED_COPPER_CANDLE,
                     ModItems.WEATHERED_COPPER_CANDLE,
                     ModItems.OXIDIZED_COPPER_CANDLE,
                     ModItems.WAXED_COPPER_CANDLE,
                     ModItems.WAXED_EXPOSED_COPPER_CANDLE,
                     ModItems.WAXED_WEATHERED_COPPER_CANDLE,
                     ModItems.WAXED_OXIDIZED_COPPER_CANDLE);
    }
}
