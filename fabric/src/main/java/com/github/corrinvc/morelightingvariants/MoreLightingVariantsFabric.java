package com.github.corrinvc.morelightingvariants;

import com.github.corrinvc.morelightingvariants.registries.ModBlocks;
import com.github.corrinvc.morelightingvariants.registries.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MoreLightingVariantsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();

        bind(BuiltInRegistries.BLOCK, ModBlocks::register);
        bind(BuiltInRegistries.ITEM, ModItems::register);

        addToCreativeTabs();

        BlockEntityType.CAMPFIRE.addSupportedBlock(ModBlocks.COPPER_CAMPFIRE);
    }

    /** Adapted from <a href="https://github.com/VazkiiMods/Botania">Botania</a> */
    private static <T> void bind(
            Registry<T> registry, Consumer<BiConsumer<T, ResourceKey<T>>> source) {
        source.accept((t, key) ->
                Registry.register(registry, key, t));
    }

    private void addToCreativeTabs() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.accept(ModBlocks.COPPER_JACK_O_LANTERN);
                    itemGroup.accept(ModBlocks.SOUL_JACK_O_LANTERN);
                });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.accept(ModBlocks.COPPER_CAMPFIRE);
                });
    }
}
