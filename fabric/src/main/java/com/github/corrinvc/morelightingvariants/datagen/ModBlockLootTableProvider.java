package com.github.corrinvc.morelightingvariants.datagen;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    protected ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.COPPER_JACK_O_LANTERN);
        dropSelf(ModBlocks.SOUL_JACK_O_LANTERN);

        add(ModBlocks.COPPER_CAMPFIRE,
                block -> this.createSilkTouchDispatchTable(
                        block,  (LootPoolEntryContainer.Builder<?>)this.applyExplosionCondition(
                                block, LootItem.lootTableItem(Items.COPPER_INGOT).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))));

        add(ModBlocks.COPPER_CANDLE, this::createCandleDrops);
        add(ModBlocks.EXPOSED_COPPER_CANDLE, this::createCandleDrops);
        add(ModBlocks.WEATHERED_COPPER_CANDLE, this::createCandleDrops);
        add(ModBlocks.COPPER_CANDLE_CAKE, createCandleCakeDrops(ModBlocks.COPPER_CANDLE));
        //dropSelf();
    }
}
